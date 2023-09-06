package com.tiago_mzm.gymapp.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tiago_mzm.gymapp.data.AdminUser
import com.tiago_mzm.gymapp.databinding.ItemAdminuserBinding

class UserAdminViewHolder (view:View):RecyclerView.ViewHolder(view){

    val binding = ItemAdminuserBinding.bind(view)

    fun render(userModelo: AdminUser,
               clicBotonPagar: (AdminUser) -> Unit
    )
    {
        binding.textView.text = userModelo.nombre
        binding.textView2.text = userModelo.documento
        binding.textView9.text = userModelo.plan
        binding.textView10.text = userModelo.pago
        binding.button4.setOnClickListener { clicBotonPagar(userModelo)}

    }
}