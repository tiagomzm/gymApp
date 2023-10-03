package com.tiago_mzm.gymapp.data

import com.tiago_mzm.gymapp.model.Usuario

interface AdaptadorListener {
    fun onEditItemClick(usuario: Usuario)
    fun onDeleteItemClick(usuario: Usuario)
}