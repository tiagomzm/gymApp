package com.tiago_mzm.gymapp.integration

import com.google.gson.annotations.SerializedName

data class PlansResponse(
    @SerializedName("id") var id : String,
    @SerializedName("idPlan") var idPlan : Long,
    @SerializedName("name") var nombre:String,
    @SerializedName("price") var precio:Long,
    @SerializedName("period") var periodo:String
)