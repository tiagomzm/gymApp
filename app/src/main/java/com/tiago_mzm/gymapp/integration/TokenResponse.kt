package com.tiago_mzm.gymapp.integration

import com.google.gson.annotations.SerializedName

data class TokenResponse(
    @SerializedName("token") var token: String
)
