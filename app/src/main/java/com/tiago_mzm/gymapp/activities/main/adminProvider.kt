package com.tiago_mzm.gymapp.activities.main

import com.tiago_mzm.gymapp.data.admin

class adminProvider {
    companion object{
        val listaUsuarioPrueba = listOf<admin>(
            admin("Camila","Alzate","Mensualidad"),
            admin("Felipe","Ciro","Anual"),
            admin("Santiago","Agudelo","Mensualidad"),
            admin("Santiago","Castañeda","Mensualidad"),
            admin("Alejandra","Ramirez","Anual"),
            admin("Leidy","Echavarria","Semestral"),
            admin("Vanessa","Cano","trimestral"),
        )
    }
}