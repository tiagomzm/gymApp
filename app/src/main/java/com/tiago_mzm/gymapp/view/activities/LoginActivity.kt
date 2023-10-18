package com.tiago_mzm.gymapp.view.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import com.tiago_mzm.gymapp.R
import com.tiago_mzm.gymapp.databinding.ActivityLoginBinding
import com.tiago_mzm.gymapp.model.Usuario
import com.tiago_mzm.gymapp.view.LoginViewModel


class   LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding

    val listaUsuarios = ArrayList<Usuario>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        listaUsuarios.add(Usuario("admin", "admin123","ADMIN"))
        listaUsuarios.add(Usuario("user", "user123","USUARIO"))

        // Obtén referencias a las vistas.
        val editTextUsuario = findViewById<TextInputLayout>(R.id.usuario)
        val editTextContraseña = findViewById<EditText>(R.id.contraseña)
        val buttonIngresar = findViewById<Button>(R.id.ingresar)

        // Define el evento click del botón "Ingresar".
        buttonIngresar.setOnClickListener(View.OnClickListener {
            val nombreUsuario = editTextUsuario.editText?.text.toString()
            val contraseña = editTextContraseña.text.toString()
            var rol = 0

            var loginExitoso = false

            for (usuario in listaUsuarios) {
                if (usuario.nombreUsuario == nombreUsuario && usuario.contraseña == contraseña) {
                    if(usuario.rol == "ADMIN"){
                        rol = 1
                    }else{
                        rol = 2
                    }

                    // Las credenciales son correctas.
                    loginExitoso = true
                    break
                }
            }

            if (loginExitoso) {
                for (usuario in listaUsuarios){
                    if(rol == 1){
                        val intent= Intent(this, admin::class.java).apply { putExtra("usuario",nombreUsuario)  }
                        startActivity(intent)
                    }else if (rol == 2){
                        val intent= Intent(this, viewUser::class.java).apply { putExtra("usuario",nombreUsuario) }
                        startActivity(intent)
                    }
                }

                // Inicio de sesión exitoso, realiza la acción deseada (por ejemplo, abre la siguiente actividad).
                Toast.makeText(this@LoginActivity, "Inicio de sesión exitoso"+ nombreUsuario, Toast.LENGTH_SHORT)
                    .show()
            } else {
                // Mostrar un mensaje de error o realizar otra acción apropiada.
                Toast.makeText(this@LoginActivity, "Credenciales incorrectas", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    
    }
    fun abrirRegistro(view: View){
        val intent= Intent(this, registration::class.java).apply {  }
        startActivity(intent)
    }
    fun abrirAplicacion(view: View){
        val intent= Intent(this, admin::class.java).apply {  }
        startActivity(intent)
    }

}
