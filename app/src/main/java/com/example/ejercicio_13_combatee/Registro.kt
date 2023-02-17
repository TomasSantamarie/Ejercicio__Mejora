package com.example.ejercicio_13_combatee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import com.example.ejercicio_13_combatee.databinding.ActivityRegistroBinding
import com.google.firebase.auth.FirebaseAuth

class Registro : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.noCoinciden.isVisible = false
        binding.login2.isEnabled = false

        binding.login2.setOnClickListener { acceder() }

        binding.crearCuenta2.setOnClickListener { cambioPagina() }


        binding.contrasena2.addTextChangedListener( object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (!binding.contrasena1.text.toString().equals(findViewById<EditText>(R.id.contrasena2).text.toString())) {
                    binding.noCoinciden.isVisible = true
                    binding.login2.isEnabled = false
                } else {
                    binding.noCoinciden.isVisible = false
                    binding.login2.isEnabled = true
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {} })
    }

    private fun acceder() {

        val email = binding.correo.text
        val pss = binding.contrasena1.text
        binding.login2.setOnClickListener {
            if (email.isNotEmpty() && pss.isNotEmpty()){

                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(email.toString(),
                        pss.toString()).addOnCompleteListener {

                        if (it.isSuccessful){
                            cambioPagina2(it.result?.user?.email ?:"", pss.toString())
                        }else {
                            alerta()
                        }
                    }
            }
        }
    }
    private fun cambioPagina() {
        val intent = Intent(this, Logeo::class.java)
        startActivity(intent)
    }
    private fun alerta(){
        val builder = AlertDialog.Builder(this)

        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autentificando al usuario")
        builder.setPositiveButton("Aceptar", null)

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun cambioPagina2(email:String, pss: String){

        val registroIntent = Intent(this, Logeo::class.java).apply {
            putExtra("email", email)
            putExtra("contraseña", pss)
        }
        startActivity(registroIntent)
    }
}