package com.tiago_mzm.gymapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class  User (
    @PrimaryKey val id: Int,
    @ColumnInfo var name: String,
    @ColumnInfo var tipo_doc: String,
    @ColumnInfo var documento: String,
    @ColumnInfo var celular: String,
    @ColumnInfo var correo: String,
    @ColumnInfo var password: String,
    @ColumnInfo var rol: String
)