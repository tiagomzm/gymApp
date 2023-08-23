package com.tiago_mzm.gymapp.activities.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tiago_mzm.gymapp.R
import com.tiago_mzm.gymapp.data.AdminUser

class adminAdapter(private val listaAdminPrueba: List<AdminUser>) : RecyclerView.Adapter<adminViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adminViewHolder {
        val layoutInflater =  LayoutInflater.from(parent.context)
        return  adminViewHolder(layoutInflater.inflate(R.layout.lista,parent,false))
    }

    override fun getItemCount(): Int = listaAdminPrueba.size

    override fun onBindViewHolder(holder: adminViewHolder, position: Int) {
        val item = listaAdminPrueba[position]
        holder.render(item)
    }

}