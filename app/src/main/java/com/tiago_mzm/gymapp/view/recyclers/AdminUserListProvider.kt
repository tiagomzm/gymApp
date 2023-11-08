package com.tiago_mzm.gymapp.view.recyclers

import com.tiago_mzm.gymapp.model.entities.AdminUser

class AdminUserListProvider {
    companion object{
        val userList = listOf<AdminUser>( AdminUser("prueba1@udo.com","","y","20000"),
            AdminUser("prueba@udo.com","123","m","40000"),
            AdminUser("prueba1@udo.com","124","n","50000"),
            AdminUser("prueba2@udo.com","125","s","60000"),
            AdminUser("prueba3@udo.com","126","s","70000"),
            AdminUser("prueba4@udo.com","127","s","80000"),
            AdminUser("prueba5@udo.com","128","s","90000"),
            AdminUser("prueba6@udo.com","129","s","10000"),
        )

    }

}