package com.tiago_mzm.gymapp.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User (
    @PrimaryKey(autoGenerate = true) val id:Int = 0,
    @ColumnInfo(name = "nombre") var nombre: String,
    @ColumnInfo(name = "tipo_doc") var tipo_doc: String,
    @ColumnInfo(name = "documento") var documento: String,
    @ColumnInfo(name = "correo") var correo: String,
    @ColumnInfo(name = "password") var password: String,
    @ColumnInfo(name = "celular") var celular: String,
    @ColumnInfo(name = "rol") var rol: String
    )
