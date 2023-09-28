package com.tiago_mzm.gymapp

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class registration : AppCompatActivity() {


    var tnombre: EditText?=null
    var ttipo:EditText?=null
    var tdocumento:EditText?=null
    var tcelular:EditText?=null
    var tcorreo:EditText?=null
    var tcontrasena:EditText?=null
    var tid="1"
    var trol="admin"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
    }

    fun regresarLogin(view: View){
        val intent= Intent(this,LoginActivity ::class.java).apply {  }
        startActivity(intent)
    }

    fun  instarUsuario(view: View){
        var conexion = SQLite(this,"pmovil",null,1)
        var baseDatos = conexion.writableDatabase
        var id = tid;
        var rol= trol;
        var nombre = tnombre?.text.toString()
        var tipo = ttipo?.text.toString()
        var documento = tdocumento?.text.toString()
        var celular = tcelular?.text.toString()
        var correo = tcorreo?.text.toString()
        var contrasena = tcontrasena?.text.toString()

        if(nombre.isEmpty()==false && tipo.isEmpty() ==false && documento.isEmpty()==false &&celular.isEmpty()==false && correo.isEmpty()==false && contrasena.isEmpty()==false){
            var  registro = ContentValues()
            registro.put("id",id)
            registro.put("nombre",nombre)
            registro.put("tipo",tipo)
            registro.put("documento",documento)
            registro.put("celular",celular)
            registro.put("correo",correo)
            registro.put("contrasena",contrasena)
            registro.put("rol",rol)
            baseDatos.insert("user",null,registro)
            tnombre?.setText("")
            ttipo?.setText("")
            tdocumento?.setText("")
            tcelular?.setText("")
            tcorreo?.setText("")
            tcontrasena?.setText("")
            Toast.makeText(this,"Se ha insertado exitosamente",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this,"Los campos debe de tener texto",Toast.LENGTH_LONG).show()
        }

    }
}