package com.tiago_mzm.gymapp.integration

import com.google.gson.annotations.SerializedName

data class PlansResponse(
    @SerializedName("id") var id : String,
    @SerializedName("nombre") var nombre:String,
    @SerializedName("precio") var precio:Long,
    @SerializedName("periodo") var periodo:String
)