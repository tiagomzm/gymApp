package com.tiago_mzm.gymapp.view.activities


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.tiago_mzm.gymapp.R
import com.tiago_mzm.gymapp.integration.ListPlans
import com.tiago_mzm.gymapp.view.fragments.edit
import com.tiago_mzm.gymapp.view.fragments.FragmentPago
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class viewUser : AppCompatActivity() {

    lateinit var planes: ListPlans

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_user)
        val bundle = intent.extras
        val usuario = bundle?.getString("usuario")
        val textoUsuario = findViewById<TextView>(R.id.textView18)
        textoUsuario.text = usuario

        val btnEditar = findViewById<Button>(R.id.actualizarDatos)
        val btnPago = findViewById<Button>(R.id.button)
        val planesTexto = findViewById<TextView>(R.id.textView8)
        // Initialize the "planes" property here
        planes = ListPlans()
        val lista = "";

        val precio = "";
        val plan = "";
        GlobalScope.launch {
            try {
                val dataAut = planes.operateAut("prueba", "prueba").token
                val call = planes.getPlans(dataAut)
                val response = call
                val i = response.size
                var lista = "";
                for( dato in response){
                    lista += "nombrePlan: " + dato.nombre
                    lista += " plan: " + dato.periodo
                    lista += " valor: " + dato.precio + "\n"
                }
                planesTexto.text = lista
            } catch (e: Exception) {
                // Handle the exception, log it, or display an error message.
                e.printStackTrace()
            }
        }

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