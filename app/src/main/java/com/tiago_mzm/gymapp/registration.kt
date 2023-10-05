package com.tiago_mzm.gymapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.tiago_mzm.gymapp.data.database.AppDatabase
import com.tiago_mzm.gymapp.data.database.dao.UserDAO
import com.tiago_mzm.gymapp.data.database.entities.User
import com.tiago_mzm.gymapp.databinding.ActivityRegistrationBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
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

        db = Room.databaseBuilder(this,AppDatabase::class.java,"pmovil").build()
        val dao = db.getUserDao()
        val datos = User(
            0,
            "prueba",
            "CC",
            "1234567890",
            "prueba@pruba.com",
            "12345",
            "1234567890",
            "user"
        )
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertAll(datos)
        }

    }
}