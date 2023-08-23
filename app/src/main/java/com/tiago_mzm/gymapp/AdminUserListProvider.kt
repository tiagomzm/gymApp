package com.tiago_mzm.gymapp

import com.tiago_mzm.gymapp.data.AdminUser

class AdminUserListProvider {
    companion object{
        val userList = listOf<AdminUser>( AdminUser("Nombre1","11","y","10000"),
            AdminUser("Nombre2","12","m",""),
            AdminUser("Nombre3","13","n",""),
            AdminUser("Nombre4","14","s",""),
            AdminUser("Nombre5","15","s",""),
            AdminUser("Nombre6","16","s",""),
            AdminUser("Nombre7","17","s",""),
            AdminUser("Nombre8","18","s",""),
        )

    }

}