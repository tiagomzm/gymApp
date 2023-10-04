package com.tiago_mzm.gymapp

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import com.tiago_mzm.gymapp.data.database.AdaptadorUser
import com.tiago_mzm.gymapp.data.database.AppDatabase
import com.tiago_mzm.gymapp.data.database.entities.User
import com.tiago_mzm.gymapp.databinding.ActivityRegistrationBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope

import kotlinx.coroutines.launch



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
        db = AppDatabase.getInstance(this)
        val user = User(id = 1, name = "Aleja Moreno", tipo_doc = "cc", documento = "14090", celular = "312654891","prueba@prueba.com", password = "123","user")
        GlobalScope.launch(Dispatchers.IO){
            db.UserDAO().insertAll(user)

        }

    }


}