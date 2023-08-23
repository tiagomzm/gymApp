package com.tiago_mzm.gymapp.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tiago_mzm.gymapp.R
import com.tiago_mzm.gymapp.data.AdminUser

class UserAdminViewHolder (view:View):RecyclerView.ViewHolder(view){

    val userNombre = view.findViewById<TextView>(R.id.textView)
    val userDocumento= view.findViewById<TextView>(R.id.textView2)
    val userPlan = view.findViewById<TextView>(R.id.textView9)
    val userPago = view.findViewById<TextView>(R.id.textView10)
    fun render(adminUser: AdminUser){
        userNombre.text = adminUser.nombre
        userDocumento.text = adminUser.documento
        userPlan.text = adminUser.plan
        userPago.text = adminUser.pago

    }
}