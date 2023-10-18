package com.tiago_mzm.gymapp.ui.login

import com.tiago_mzm.gymapp.model.Usuario

interface AdaptadorListener {
    fun onEditItemClick(usuario: Usuario)
    fun onDeleteItemClick(usuario: Usuario)
}