package com.tiago_mzm.gymapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class registration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
    }

    fun regresarLogin(view: View){
        val intent= Intent(this,LoginActivity ::class.java).apply {  }
        startActivity(intent)
    }
}