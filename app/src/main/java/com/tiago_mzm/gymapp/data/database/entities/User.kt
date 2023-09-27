package com.tiago_mzm.gymapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class  User (
    @PrimaryKey val code: Int,
    @ColumnInfo var name: String,
    @ColumnInfo var description: String,
    @ColumnInfo var quantity: Int,
    @ColumnInfo var price: Double
)