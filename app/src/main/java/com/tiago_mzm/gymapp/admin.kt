package com.tiago_mzm.gymapp


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tiago_mzm.gymapp.adapter.UserAdminAdapter


class admin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
        initRecyclerView()
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