package com.tiago_mzm.gymapp.view.recyclers

import com.tiago_mzm.gymapp.model.entities.AdminUser

class AdminUserListProvider {
    companion object{
        val userList = listOf<AdminUser>( AdminUser("Nombre1","11","y","20000"),
            AdminUser("prueba@udo.com","12","m","40000"),
            AdminUser("Nombre3","13","n","50000"),
            AdminUser("Nombre4","14","s","60000"),
            AdminUser("Nombre5","15","s","70000"),
            AdminUser("Nombre6","16","s","80000"),
            AdminUser("Nombre7","17","s","90000"),
            AdminUser("Nombre8","18","s","10000"),
        )

    }

}