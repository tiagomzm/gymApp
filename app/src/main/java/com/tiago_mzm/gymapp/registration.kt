package com.tiago_mzm.gymapp

import android.content.Intent
import android.os.Bundle
import android.text.method.Touch
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.tiago_mzm.gymapp.data.database.AppDatabase
import com.tiago_mzm.gymapp.data.database.dao.UserDAO
import com.tiago_mzm.gymapp.data.database.entities.User
import com.tiago_mzm.gymapp.databinding.ActivityRegistrationBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.UUID


class registration : AppCompatActivity() {

    private var _binding: ActivityRegistrationBinding? = null

    private val  binding get() = _binding!!
    private lateinit var db: AppDatabase
    var tnombre : EditText?=null
    var ttipo : EditText?=null
    var tdoc : EditText?=null
    var tcelular : EditText?=null
    var tcorreo : EditText?=null
    var tclave : EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        val btnInsertar = findViewById<Button>(R.id.button)

        tnombre = findViewById(R.id.editTextText5)
        ttipo = findViewById(R.id.editTextText4)
        tdoc = findViewById(R.id.editTextText3)
        tcelular = findViewById(R.id.editTextText2)
        tcorreo = findViewById(R.id.editTextText)
        tclave = findViewById(R.id.editTextTextPassword2)


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
        val id = UUID.randomUUID().hashCode()
        val rol = "user"
        val datos = User(
            id,
            tnombre?.text.toString(),
            ttipo?.text.toString(),
            tdoc?.text.toString(),
            tcorreo?.text.toString(),
            tclave?.text.toString(),
            tcelular?.text.toString(),
            rol
        )
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertAll(datos)
        }
        Toast.makeText(this,"Se guardo correctamente",Toast.LENGTH_SHORT).show()
    }
}