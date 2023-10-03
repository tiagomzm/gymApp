package com.tiago_mzm.gymapp.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.tiago_mzm.gymapp.data.database.entities.User

@Dao
interface UserDAO {
    @Query("SELECT * FROM user")
    suspend fun obtenerUsuarios(): MutableList<User>

   // @Query("SELECT * FROM User WHERE code = :code")
    //fun findByCode(code: Int): User

    @Insert
    suspend fun agregarUsuario(usuario:User)

    @Query("UPDATE user set password = :password WHERE correo = :usuario")
    suspend fun actualizarUsuario(usuario: String,password:String)

    //@Delete
    //fun delete(product: User)

    //@Query("DELETE FROM User")
    //fun deleteAll()
}
