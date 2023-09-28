package com.tiago_mzm.gymapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLite  (
    context: Context?,
    name:String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
): SQLiteOpenHelper(context,name,factory,version){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table user (id text primary key,nombre text,tipo_doc text,documento text,celular text,correo text,password text,rol text)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}