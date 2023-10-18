package com.tiago_mzm.gymapp.view.activities


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.tiago_mzm.gymapp.R
import com.tiago_mzm.gymapp.view.fragments.edit
import com.tiago_mzm.gymapp.view.fragments.FragmentPago


class viewUser : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_user)
        val bundle = intent.extras
        val usuario = bundle?.getString("usuario")
        val textoUsuario = findViewById<TextView>(R.id.textView18)
        textoUsuario.text = usuario

        val btnEditar = findViewById<Button>(R.id.actualizarDatos)
        val btnPago = findViewById<Button>(R.id.button)


        btnEditar.setOnClickListener {
            val nuevo = edit()
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView,nuevo)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        btnPago.setOnClickListener {
            val nuevo = FragmentPago()
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView,nuevo)
            transaction.addToBackStack(null)
            transaction.commit()
        }

    }

    fun salirVistaUsuario(view: View){
        val intent= Intent(this, LoginActivity ::class.java).apply {  }
        startActivity(intent)
    }


}