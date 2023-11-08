package com.tiago_mzm.gymapp.view.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.tiago_mzm.gymapp.R
import com.tiago_mzm.gymapp.databinding.ActivityLoginBinding
import com.tiago_mzm.gymapp.databinding.ActivityMainBinding
import com.tiago_mzm.gymapp.model.Usuario
import com.tiago_mzm.gymapp.view.LoginViewModel


class   LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding

    private lateinit var client: GoogleSignInClient
    private val signInLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        //if (result.resultCode == RESULT_OK) {
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            if (data != null) {
                handleGoogleSignInResult(data)
            }
        }
    }

    val listaUsuarios = ArrayList<Usuario>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btGoogle?.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val signInIntent = client.signInIntent
            signInLauncher.launch(signInIntent)}


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



        //Auth con google
        val options = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("504473784627-7ibo7s0dl7ludk7nt4mcp5ri521aa96f.apps.googleusercontent.com")
            .requestEmail()
            .build()
        val googleSignInClient = GoogleSignIn.getClient(this, options)
        googleSignInClient.signOut().addOnCompleteListener {
            //Cierre de sesión completado
        }
        client = GoogleSignIn.getClient(this, options)
    
    }
    fun abrirRegistro(view: View){
        val intent= Intent(this, registration::class.java).apply {  }
        startActivity(intent)
    }
    fun abrirAplicacion(view: View){
        val intent= Intent(this, admin::class.java).apply {  }
        startActivity(intent)
    }

    private fun handleGoogleSignInResult(data: Intent) {
        val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
        try {
            val account: GoogleSignInAccount = task.getResult(ApiException::class.java)
            val credential: AuthCredential = GoogleAuthProvider.getCredential(account.idToken, null)
            FirebaseAuth.getInstance().signInWithCredential(credential)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // La autenticación fue exitosa
                        val intent = Intent(applicationContext, viewUser::class.java)
                        intent.putExtra("options", client.apiOptions)
                        startActivity(intent)
                        // Realiza acciones adicionales
                    } else {
                        // La autenticación fallo
                        Toast.makeText(applicationContext, task.exception?.message ?: "", Toast.LENGTH_SHORT).show()
                        // Manejar la excepción
                    }
                }
        } catch (e: ApiException) {
            e.printStackTrace()
        }
    }
}

