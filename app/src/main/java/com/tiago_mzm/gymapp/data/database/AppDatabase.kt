package com.tiago_mzm.gymapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tiago_mzm.gymapp.data.database.dao.UserDAO
import com.tiago_mzm.gymapp.data.database.entities.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getUserDao() : UserDAO

   /*companion object {
        private const val DATABASE_NAME = "vibras.db"

        private lateinit var instance: AppDatabase

        fun getInstance(context: Context?): AppDatabase {
            if (::instance.isInitialized) {
                println("Encontré una instancia para conectarte $instance")
                return instance
            } else {
                instance = Room.databaseBuilder(
                    context!!.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME
                )
                    .allowMainThreadQueries()
                    .build()

                return instance
            }

        }
   }*/

}