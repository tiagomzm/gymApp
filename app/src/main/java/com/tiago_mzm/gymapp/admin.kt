package com.tiago_mzm.gymapp


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tiago_mzm.gymapp.adapter.UserAdminAdapter


class admin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
        initRecyclerView()
        val bundle = intent.extras
        val usuario = bundle?.getString("usuario")
        Toast.makeText(this@admin,usuario , Toast.LENGTH_SHORT)
            .show()
        val textoUsuario = findViewById<TextView>(R.id.textView16)
        textoUsuario.text = "admin"
       // val documento =  findViewById<TextView>(R.id.textView16)
       // documento.text = "890984746-7"
    }

    fun salirVista(view: View){
        val intent= Intent(this,LoginActivity ::class.java).apply {  }
        startActivity(intent)
    }

    private  fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.reciclerview_usuarios)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = UserAdminAdapter(AdminUserListProvider.userList)
    }
}