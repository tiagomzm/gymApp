package com.tiago_mzm.gymapp

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.tiago_mzm.gymapp.data.database.AdaptadorUser
import com.tiago_mzm.gymapp.data.database.AppDatabase
import com.tiago_mzm.gymapp.data.database.entities.User
import com.tiago_mzm.gymapp.databinding.ActivityRegistrationBinding
import kotlinx.coroutines.launch

class registration : AppCompatActivity() {

    lateinit var binding: ActivityRegistrationBinding

    var listaUser: MutableList<User> = mutableListOf()

    lateinit var  adatador : AdaptadorUser
    lateinit var room: AppDatabase
    lateinit var  usuario: User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        room = Room.databaseBuilder(this,AppDatabase::class.java,"vibras").build()
    }

    fun regresarLogin(view: View){
        val intent= Intent(this,LoginActivity ::class.java).apply {  }
        startActivity(intent)
    }

    fun obtenerUsuarios(room:AppDatabase){
        lifecycleScope.launch {
            listaUser = room.daoUsuario().obtenerUsuarios()
           // adatador = AdaptadorUser(listaUser,this@registration)

        }
    }

    fun  agregarUser(room: AppDatabase,user: User){
        lifecycleScope.launch {
            room.daoUsuario().agregarUsuario(user)
            obtenerUsuarios(room)
            limpierCampos()
        }
    }

    fun limpierCampos(){
        usuario.name
    }


}