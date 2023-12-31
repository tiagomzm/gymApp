package com.tiago_mzm.gymapp.persistence.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tiago_mzm.gymapp.model.entities.User
import kotlinx.coroutines.flow.Flow


@Dao
interface UserDAO {

    @Query("SELECT * FROM user")
    fun getAllUser(): Flow<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(user: User)


}
