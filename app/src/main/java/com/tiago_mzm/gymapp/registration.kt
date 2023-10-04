package com.tiago_mzm.gymapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.tiago_mzm.gymapp.data.database.AppDatabase
import com.tiago_mzm.gymapp.data.database.dao.UserDAO
import com.tiago_mzm.gymapp.data.database.entities.User
import com.tiago_mzm.gymapp.databinding.ActivityRegistrationBinding


class registration : AppCompatActivity() {

    private var _binding: ActivityRegistrationBinding? = null

    private val  binding get() = _binding!!
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        val btnInsertar = findViewById<Button>(R.id.button)
        btnInsertar.setOnClickListener {
            onViewCreated()
        }
    }

    fun regresarLogin(view: View){
        val intent= Intent(this,LoginActivity ::class.java).apply {  }
        startActivity(intent)
    }

    fun onViewCreated(){
        val database = AppDatabase.getInstance(this)
        val user: UserDAO = database.UserDAO()

        val datos = User(
            0,
            "Ejemplo",
            "CC",
            "1234567890",
            "ejemplo@gmail.com",
            "12345",
            "1234567890",
            "ADMIN"
        )

        user.insertarDatos(datos);
    }
}