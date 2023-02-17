package com.example.ejercicio_13_combatee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio_13_combatee.databinding.ActivityPartidaBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject

class ElegirPartida : AppCompatActivity() {
    private lateinit var binding: ActivityPartidaBinding
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_objeto)
        binding = ActivityPartidaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

            db.collection("usuario_ejemplo").document(usuario.getCorreo())
                .get()
                .addOnSuccessListener {
                    if (it != null) {
                        var aux= it.get("partidas.listaPartidas")
                       
                        val part = it.toObject<Partidas>()
                        val usuario_ejemplo = db.collection("usuario_ejemplo").document(usuario.getCorreo()).get()
                        binding.partida1.text=aux.toString()
                    }
                }






    }
}

