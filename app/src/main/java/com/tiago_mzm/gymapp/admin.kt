package com.tiago_mzm.gymapp


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tiago_mzm.gymapp.adapter.UserAdminAdapter
import com.tiago_mzm.gymapp.data.AdminUser
import com.tiago_mzm.gymapp.databinding.ActivityAdminBinding


class admin : AppCompatActivity() {
    private lateinit var binding: ActivityAdminBinding
    private lateinit var adapter: UserAdminAdapter
    private var listaUsuariosTratados: MutableList<AdminUser> = AdminUserListProvider.userList.toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        val bundle = intent.extras
        val usuario = bundle?.getString("usuario")
        Toast.makeText(this@admin,usuario , Toast.LENGTH_SHORT)
            .show()
        //val textoUsuario = findViewById<TextView>(R.id.textView16)
        //textoUsuario.text = "admin"
        // val documento =  findViewById<TextView>(R.id.textView16)
        // documento.text = "890984746-7"
        binding.editTextText7.addTextChangedListener { usuarioFilrado ->
            val usauriosFiltrados =  AdminUserListProvider.userList.filter {
                    usuario -> usuario.nombre.lowercase().contains(usuarioFilrado.toString().lowercase()) }
            adapter.listtaActualizada(usauriosFiltrados)
        }


    }

    fun salirVista(view: View){
        val intent= Intent(this,LoginActivity ::class.java).apply {  }
        startActivity(intent)
    }

    private  fun initRecyclerView(){

        adapter = UserAdminAdapter(
            userList = listaUsuariosTratados,
            clicBotonPagar = {pagar -> pagarBoton(pagar)}
        )
        binding.reciclerviewUsuarios.layoutManager = LinearLayoutManager(this)
        binding.reciclerviewUsuarios.adapter = adapter
    }
    private fun pagarBoton (pago: AdminUser){
        Toast.makeText(this, pago.nombre, Toast.LENGTH_SHORT).show()
    }
}