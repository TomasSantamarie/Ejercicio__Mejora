package com.example.ejercicio_13_combatee

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio_13_combatee.databinding.ActivityDerrotaBinding
import com.google.firebase.firestore.FirebaseFirestore

class Derrota : AppCompatActivity() {
    private lateinit var binding: ActivityDerrotaBinding
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_derrota)
        binding = ActivityDerrotaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.comenzar.setOnClickListener {
            eliminar()

            val intent = Intent(this, ElegirPartida::class.java)
            startActivity(intent)
        }


    }

    private fun eliminar() {
        usuario.getPartidas().eliminarPartida(number)
        db.collection("usuario_ejemplo").document(usuario.getCorreo()).set(usuario)
    }


}