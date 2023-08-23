package com.tiago_mzm.gymapp


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tiago_mzm.gymapp.adapter.UserAdminAdapter
import com.tiago_mzm.gymapp.adapter.UserAdminViewHolder
import com.tiago_mzm.gymapp.data.AdminUser

class admin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        initRecyclerView()
    }

    private  fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.reciclerview_usuarios)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = UserAdminAdapter(AdminUserListProvider.userList)
    }
}