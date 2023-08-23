package com.tiago_mzm.gymapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tiago_mzm.gymapp.data.AdminUser
import com.tiago_mzm.gymapp.R

class UserAdminAdapter(private val userList:List<AdminUser>) : RecyclerView.Adapter<UserAdminViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdminViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UserAdminViewHolder(layoutInflater.inflate(R.layout.item_adminuser, parent, false))
    }

    override fun getItemCount(): Int = userList.size


    override fun onBindViewHolder(holder: UserAdminViewHolder, position: Int) {
        val item = userList[position]
        holder.render(item)

    }

}