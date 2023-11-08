package com.tiago_mzm.gymapp.integration


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Url

interface AppService {
    @POST("/authenticate")
    fun getToken(@Body loginRequest: LoginRequest): Call<TokenResponse>

    @GET("/api/v1/rest/plans")
    fun getPlans(@Header("Authorization") token: String): Call<List<PlansResponse>>
}