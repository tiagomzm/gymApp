package com.tiago_mzm.gymapp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tiago_mzm.gymapp.R
import com.tiago_mzm.gymapp.integration.ListPlans
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FragmentPago : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var planes : ListPlans
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        GlobalScope.launch {
            try {
                val dataAut = planes.operateAut("prueba", "prueba").token
                val call = planes.getPlans(dataAut)
                withContext(Dispatchers.Main) {
                    call
                }
            } catch (e: Exception) {
                // Handle the exception, log it, or display an error message.
                e.printStackTrace()
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pago, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentPago().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}