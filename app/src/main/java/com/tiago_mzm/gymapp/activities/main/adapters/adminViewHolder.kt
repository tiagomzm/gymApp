package com.tiago_mzm.gymapp.activities.main.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tiago_mzm.gymapp.R
import com.tiago_mzm.gymapp.data.AdminUser

class adminViewHolder(view:View): RecyclerView.ViewHolder(view) {
    val nombre = view.findViewById<TextView>(R.id.textView)
    val documento = view.findViewById<TextView>(R.id.textView2)
    val plan = view.findViewById<TextView>(R.id.textView9)
    val pago = view.findViewById<TextView>(R.id.textView10)

    fun render(admin: AdminUser){
        nombre.text = admin.nombre
        documento.text = admin.documento
        plan.text = admin.plan
        pago.text = admin.pago
    }
}