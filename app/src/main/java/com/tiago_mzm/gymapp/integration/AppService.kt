package com.tiago_mzm.gymapp.integration


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Url

interface AppService {
    @POST()
    fun getToken(@Url url:String, @Body loginRequest: LoginRequest): Call<TokenResponse>

    @GET()
    suspend fun getPlans(@Url url:String,@Header("Authorization") token:String): Call<PlansResponse>
}