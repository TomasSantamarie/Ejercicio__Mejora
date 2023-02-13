package com.example.ejercicio_13_combatee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.ejercicio_13_combatee.databinding.ActivitySegundaPagBinding

class SegundaPag : AppCompatActivity() {

    private lateinit var binding: ActivitySegundaPagBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundaPagBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var aux = ""
        binding.humano.setOnClickListener { cambioFoto2(binding.humano.text.toString())
            aux = "Humano"}
        binding.goblin.setOnClickListener { cambioFoto2(binding.goblin.text.toString())
            aux = "Goblin"}
        binding.elfo.setOnClickListener { cambioFoto2(binding.elfo.text.toString())
            aux = "Elfo"}
        binding.enano.setOnClickListener { cambioFoto2(binding.enano.text.toString())
            aux = "Enano"}

        findViewById<Button>(R.id.aceptar).setOnClickListener{cambioPagina2(aux)}
    }


    private fun cambioFoto2(text: String) {

        val imagen = binding.imageView

        if (text.equals("Humano"))
            imagen.setImageResource(R.drawable.humano)

        if (text.equals("Goblin"))
            imagen.setImageResource(R.drawable.goblin)

        if (text.equals("Elfo"))
            imagen.setImageResource(R.drawable.elfo)

        if (text.equals("Enano"))
            imagen.setImageResource(R.drawable.enano)
    }
    private fun cambioPagina2(raza: String) {

        val bundle = intent.extras
        val clase = bundle?.getString("Clase")

        val intent = Intent(this, Activity::class.java).apply {
            putExtra("Clase",clase)
            putExtra("Raza",raza)
        }

        startActivity(intent)
    }
}