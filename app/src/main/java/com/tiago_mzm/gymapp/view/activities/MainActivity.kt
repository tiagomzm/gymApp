package com.tiago_mzm.gymapp.view.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import android.view.View
import com.tiago_mzm.gymapp.R

class MainActivity : AppCompatActivity() {



    private lateinit var appBarConfiguration: AppBarConfiguration



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }

    fun abrirRegistro(view: View){
        val intent=Intent(this, registration::class.java).apply {  }
        startActivity(intent)
    }

}