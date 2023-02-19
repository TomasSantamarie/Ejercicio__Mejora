package com.example.ejercicio_13_combatee

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio_13_combatee.databinding.ActivityLogeoBinding
import com.google.firebase.auth.FirebaseAuth

class Logeo : AppCompatActivity() {

    private lateinit var binding: ActivityLogeoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogeoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.login.setOnClickListener { acceder() }
        binding.crearCuenta.setOnClickListener { cambioPagina() }

        var bundle = intent.extras
        val pss = bundle?.getString("contraseña")
        val email = bundle?.getString("email")

        binding.user.setText(email)
        binding.textPassword.setText(pss)

    }

    private fun acceder() {

        val email = binding.user.text
        val pss = binding.textPassword.text
        binding.login.setOnClickListener{
            if (email.isNotEmpty() && pss.isNotEmpty()){

                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(email.toString(),
                        pss.toString()).addOnCompleteListener {
                        if (it.isSuccessful){
                            cambioPagina2()
                            usuario.setCorreo(email.toString())
                        }else {
                            val text = "Usuario o contraseña no valido!"
                            val duration = Toast.LENGTH_SHORT
                            val toast = Toast.makeText(applicationContext, text, duration)
                            toast.show()
                        }
                    }
            }
        }
    }
    private fun cambioPagina() {
        val intent = Intent(this, Registro::class.java)
        startActivity(intent)
    }

    private fun cambioPagina2() {
        val intent = Intent(this, ElegirPartida::class.java)
        startActivity(intent)
    }
}