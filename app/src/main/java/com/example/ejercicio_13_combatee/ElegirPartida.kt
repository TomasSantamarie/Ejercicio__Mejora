package com.example.ejercicio_13_combatee

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio_13_combatee.databinding.ActivityPartidaBinding
import com.google.firebase.firestore.FirebaseFirestore

class ElegirPartida : AppCompatActivity() {
    private lateinit var binding: ActivityPartidaBinding
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_objeto)
        binding = ActivityPartidaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var continuar = 0
        db.collection("usuario_ejemplo").document(usuario.getCorreo())
            .get()
            .addOnSuccessListener {
                if (it != null) {
                    val user = it.toObject(Usuario::class.java)
                    if (user != null) {
                        usuario.setPartidas(user!!.getPartidas())
                        for (partida in usuario.getPartidas().getListaPartidas()) {
                            partida.setNombrePersonaje(partida.getPersonaje().getNombre())
                        }
                    }


                    val listaPartidas = usuario.getPartidas().getListaPartidas()
                    var aux3 = ""
                    val contador = listaPartidas.size

                    if (contador >= 1) {
                        aux3 = listaPartidas[0].getNombrePersonaje().toString()
                        binding.partida1.text = aux3.toString()
                        binding.imageButton1.setImageResource(R.drawable.partida)
                        continuar++
                        if (contador >= 2) {
                            aux3 = listaPartidas[1].getNombrePersonaje()
                            binding.partida2.text = aux3.toString()
                            binding.imageButton2.setImageResource(R.drawable.partida)
                            continuar++
                            if (contador == 3) {
                                aux3 = listaPartidas[2].getNombrePersonaje().toString()
                                binding.partida3.text = aux3.toString()
                                binding.imageButton3.setImageResource(R.drawable.partida)
                                continuar++

                            } else
                                binding.imageButton3.setImageResource(R.drawable.loginn)

                        } else {
                            binding.imageButton2.setImageResource(R.drawable.loginn)
                            binding.imageButton3.setImageResource(R.drawable.loginn)
                        }

                    } else {
                        binding.imageButton1.setImageResource(R.drawable.loginn)
                        binding.imageButton2.setImageResource(R.drawable.loginn)
                        binding.imageButton3.setImageResource(R.drawable.loginn)
                    }

                }
            }
        binding.imageButton1.setOnClickListener {
            number = 0
            if (continuar > 0)
                continuarPartida(number)
            else
                nuevaPartida(number)
        }
        binding.imageButton2.setOnClickListener {
            number = 1
            if (continuar > 1)
                continuarPartida(number)
            else
                nuevaPartida(number)
        }
        binding.imageButton3.setOnClickListener {
            number = 2
            if (continuar > 2)
                continuarPartida(number)
            else
                nuevaPartida(number)
        }


    }

    private fun nuevaPartida(number: Int) {


        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun continuarPartida(number: Int) {

        db.collection("usuario_ejemplo").document(usuario.getCorreo())
            .get()
            .addOnSuccessListener {
                val user = it.toObject(Usuario::class.java)
                if (user != null) {
                    usuario.setPartidas(user!!.getPartidas())
                    for (partida in usuario.getPartidas().getListaPartidas()) {
                        partida.setNombrePersonaje(partida.getPersonaje().getNombre())
                    }
                }
                personaje_1 = usuario.getPartidas().getListaPartidas()[number].getPersonaje()
            }
        val intent = Intent(this, Mercader::class.java)
        startActivity(intent)
    }
}

