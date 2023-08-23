package com.tiago_mzm.gymapp.activities.main

import com.tiago_mzm.gymapp.data.AdminUser

class adminProvider {
    companion object{
        val listaUsuarioPrueba = listOf<AdminUser>(
            AdminUser("Camila","Alzate","Mensualidad","1"),
            AdminUser("Felipe","Ciro","Anual","2"),
            AdminUser("Santiago","Agudelo","Mensualidad","3"),
            AdminUser("Santiago","Castañeda","Mensualidad","4"),
            AdminUser("Alejandra","Ramirez","Anual","5"),
            AdminUser("Leidy","Echavarria","Semestral","6"),
            AdminUser("Vanessa","Cano","trimestral","7"),
        )
    }
}