package com.tiago_mzm.gymapp.model.entities

import androidx.room.Entity

@Entity(tableName = "user")
data class AdminUser(
    val nombre: String,
    val documento: String,
    val plan: String,
    val pago: String,
)