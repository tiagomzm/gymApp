package com.tiago_mzm.gymapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.tiago_mzm.gymapp.databinding.ActivityLoginBinding

import com.tiago_mzm.gymapp.ui.login.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }
    fun abrirRegistro(view: View){
        val intent= Intent(this,registration::class.java).apply {  }
        startActivity(intent)
    }
    fun abrirAplicacion(view: View){
        val intent= Intent(this,admin::class.java).apply {  }
        startActivity(intent)
    }

}
