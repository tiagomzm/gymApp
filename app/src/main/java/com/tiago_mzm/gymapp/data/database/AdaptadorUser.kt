package com.tiago_mzm.gymapp.data.database

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tiago_mzm.gymapp.R
import com.tiago_mzm.gymapp.data.AdaptadorListener
import com.tiago_mzm.gymapp.data.database.entities.User

class AdaptadorUser (
        val listaUsuario : MutableList<User>,
        val  listener : AdaptadorListener

        ):RecyclerView.Adapter<AdaptadorUser.ViewHolder>(){

        inner class ViewHolder(ItemView:View):RecyclerView.ViewHolder(ItemView) {
                val nombre = itemView.findViewById<TextView>(R.id.textView)
                val documento = itemView.findViewById<TextView>(R.id.textView2)
                val plan = itemView.findViewById<TextView>(R.id.textView9)
                val pago = itemView.findViewById<TextView>(R.id.textView10)
                val boton = itemView.findViewById<Button>(R.id.button4)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
               val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_adminuser,parent,false)

               return ViewHolder(vista)
        }

        override fun getItemCount(): Int {
               return  listaUsuario.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                val usuario = listaUsuario[position]

               // holder.nombre.text = usuario.name
                holder.documento.text = usuario.documento
                holder.plan.text = usuario.rol


        }

}