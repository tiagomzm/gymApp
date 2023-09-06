package com.tiago_mzm.gymapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class viewUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_user)
        val bundle = intent.extras
        val usuario = bundle?.getString("usuario")
        val textoUsuario = findViewById<TextView>(R.id.textView18)
        textoUsuario.text = usuario

    }

    fun salirVistaUsuario(view: View){
        val intent= Intent(this,LoginActivity ::class.java).apply {  }
        startActivity(intent)
    }
}