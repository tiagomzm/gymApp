package com.tiago_mzm.gymapp.integration

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ListPlans {

    private fun getRetrofit(): Retrofit {
        val timeoutMillis = 10000L

        val client = OkHttpClient.Builder()
            .connectTimeout(timeoutMillis, TimeUnit.MILLISECONDS)
            .readTimeout(timeoutMillis, TimeUnit.MILLISECONDS)
            .build()

        return  Retrofit.Builder()
            .baseUrl("https://pocapispringboot.azurewebsites.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
     suspend fun datosRetrofit(TOKEN: String) {
        val apiService  =  getRetrofit().create(AppService::class.java)
         val token = "Bearer $TOKEN"

        val plansResponseDeferred = runBlocking(Dispatchers.IO) {
            async {
                val call = apiService.getPlans(token)
                call.copy(call.id,call.idPlan,call.nombre,call.precio,call.periodo)
            }
        }
         return runBlocking {
             plansResponseDeferred
         }
    }

    fun operateAut(username: String, password: String): TokenResponse {
        val apiService = getRetrofit().create(AppService::class.java)
        val loginRequest = LoginRequest(username, password)
        val tokenResponseDeferred = runBlocking(Dispatchers.IO) {
            async {
                val call = apiService.getToken(loginRequest).execute()
                call.body() ?: throw IllegalStateException("Token response body is null")

            }

        }
        return runBlocking {
            tokenResponseDeferred.await()
        }
    }
}