package com.tiago_mzm.gymapp.activities.main.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tiago_mzm.gymapp.R
import com.tiago_mzm.gymapp.data.admin

class adminViewHolder(view:View): RecyclerView.ViewHolder(view) {
    val nombre = view.findViewById<TextView>(R.id.nomUser)
    val apellido = view.findViewById<TextView>(R.id.apellidoUser)
    val tipo = view.findViewById<TextView>(R.id.nomUser)
    val foto = view.findViewById<ImageView>(R.id.ivUser)

    fun render(admin: admin){
        nombre.text = admin.nombre
        apellido.text = admin.apellido
        tipo.text = admin.plan

    }
}