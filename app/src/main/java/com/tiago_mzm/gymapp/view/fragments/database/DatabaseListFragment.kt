package com.tiago_mzm.gymapp.view.fragments.database

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tiago_mzm.gymapp.persistence.database.AppDatabase

class DatabaseListFragment :Fragment(){
    private lateinit var db: AppDatabase
    override fun  onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
       // db = AppDatabase.getInstance(context)
        return view
    }


}