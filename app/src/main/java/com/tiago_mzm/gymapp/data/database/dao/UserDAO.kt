package com.tiago_mzm.gymapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tiago_mzm.gymapp.data.database.entities.User

@Dao
interface UserDAO {
    @Insert
    fun insertarDatos(datos: User?)

    @Query("SELECT * FROM user")
    fun obtenerTodosLosDatos(): List<User?>?

    //@Query("SELECT * FROM user")
    //fun getAll(): List<User>

   // @Query("SELECT * FROM User WHERE code = :code")
    //fun findByCode(code: Int): User

    @Insert
    fun insertAll(vararg user: User)

   /* @Query("UPDATE user set nombre = :nombre, tipodocumento = :tipo_documento,documento = :documento" +
            ",celular = :celular,password = :password WHERE correo = :correo")
    fun actualizarUsuario(nombre: String,  tipo_documento: String,documento: String, correo: String,
                          celular: String, password: String)*/

    //@Delete
    //fun delete(product: User)

    //@Query("DELETE FROM User")
    //fun deleteAll()
}
