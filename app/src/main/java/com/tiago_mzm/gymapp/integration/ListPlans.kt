package com.tiago_mzm.gymapp.integration

import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import java.lang.IllegalStateException

class ListPlans {

    private fun getRetrofit(): Retrofit {
        return  Retrofit.Builder()
            .baseUrl("https://pocapispringboot.azurewebsites.net")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getPlans(TOKEN: String): PlansResponse {
        val apiService = getRetrofit().create(AppService::class.java)

        val plansResponseDeferred = runBlocking{
            async {
                val call = apiService.getPlans().execute()
                call.body() ?: throw IllegalStateException("No se encontraron planes")
            }
        }

        return runBlocking {
            plansResponseDeferred.await()
        }
    }

     /*fun serchByName(TOKEN: String) {
        val apiService  =  getRetrofit().create(AppService::class.java)
         //val token = "Bearer $TOKEN"

        val plansResponseDeferred = runBlocking(Dispatchers.IO) {
            async {
                val call = apiService.getPlans().execute()
                call.body() ?:throw IllegalStateException("no se encontraron planes")
            }
        }
         return runBlocking {
             plansResponseDeferred
         }
    }*/

    fun operateAut(username: String, password: String): TokenResponse {
        val apiService = getRetrofit().create(AppService::class.java)
        val loginRequest = LoginRequest(username, password)
        val tokenResponseDeferred = runBlocking {
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