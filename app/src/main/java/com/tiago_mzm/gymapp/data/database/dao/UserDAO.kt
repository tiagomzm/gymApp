package com.tiago_mzm.gymapp.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.tiago_mzm.gymapp.data.database.entities.User

@Dao
interface UserDAO {
    @Query("SELECT * FROM User")
    fun getAll(): List<User>

    @Query("SELECT * FROM User WHERE code = :code")
    fun findByCode(code: Int): User

    @Insert
    fun insertAll(vararg products: User)

    @Update
    fun update(product: User)

    @Delete
    fun delete(product: User)

    @Query("DELETE FROM User")
    fun deleteAll()
}
