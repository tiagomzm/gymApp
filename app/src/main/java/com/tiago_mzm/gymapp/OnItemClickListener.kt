package com.tiago_mzm.gymapp
import android.view.View
import com.tiago_mzm.gymapp.data.database.AppDatabase


interface OnItemClickListener {
    fun onItemClick(view: View, position: Int)
}
