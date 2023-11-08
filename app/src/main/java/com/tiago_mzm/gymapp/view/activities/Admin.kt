package com.tiago_mzm.gymapp.view.activities


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.tiago_mzm.gymapp.view.recyclers.AdminUserListProvider
import com.tiago_mzm.gymapp.adapter.UserAdminAdapter
import com.tiago_mzm.gymapp.model.entities.AdminUser
import com.tiago_mzm.gymapp.databinding.ActivityAdminBinding


class admin : AppCompatActivity() {

    private lateinit var binding: ActivityAdminBinding
    private lateinit var adapter: UserAdminAdapter
    private var listaUsuariosTratados: MutableList<AdminUser> = AdminUserListProvider.userList.toMutableList()

    val db : FirebaseFirestore = FirebaseFirestore.getInstance()

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

        binding.Promociones.setOnClickListener {
            var datos = ""
            db.collection("promociones").get()
                .addOnSuccessListener { resultado -> for (promocion in resultado){
                    datos += "${promocion.id}: ${promocion.data}\n"
                }
                    binding.textView7.text = datos
            }
                .addOnFailureListener{exception ->
                    binding.textView7.text = "No se ha podido conectar"
                }
        }


    }

    fun salirVista(view: View){
        val intent= Intent(this, LoginActivity ::class.java).apply {  }
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