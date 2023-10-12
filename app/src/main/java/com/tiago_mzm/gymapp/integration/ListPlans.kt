package com.tiago_mzm.gymapp.integration

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.tiago_mzm.gymapp.integration.AppService
import com.tiago_mzm.gymapp.integration.PlansResponse
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import java.lang.IllegalStateException

class ListPlans {

    private fun getRetrofit(): Retrofit {
        return  Retrofit.Builder()
            .baseUrl("https://pocapispringboot.azurewebsites.net/api/v1/rest/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

     fun serchByName(TOKEN: String) {
        val apiService  =  getRetrofit().create(AppService::class.java)
         val token = "Bearer $TOKEN"

        val plansResponseDeferred = runBlocking(Dispatchers.IO) {
            async {
                val call = apiService.getPlans("plans/",token).execute()
                call.body() ?:throw IllegalStateException("no se encontraron planes")
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
                val call = apiService.getToken(
                    "authenticate", loginRequest).execute()
                call.body() ?: throw IllegalStateException("Token response body is null")

            }

        }
        return runBlocking {
            tokenResponseDeferred.await()
        }
    }
}