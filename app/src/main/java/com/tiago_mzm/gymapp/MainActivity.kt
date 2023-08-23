package com.tiago_mzm.gymapp

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tiago_mzm.gymapp.activities.main.adapters.adminAdapter
import com.tiago_mzm.gymapp.activities.main.adminProvider
import com.tiago_mzm.gymapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }

    fun abrirRegistro(view: View){
        val intent=Intent(this,registration::class.java).apply {  }
        startActivity(intent)
    }

    private fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.reciclerview_usuarios)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adminAdapter(adminProvider.listaUsuarioPrueba)
    }
}