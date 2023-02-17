package com.example.ejercicio_13_combatee

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isGone
import com.example.ejercicio_13_combatee.databinding.ActivityObjetoBinding

class Objeto : AppCompatActivity() {
    private lateinit var binding: ActivityObjetoBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_objeto)
        binding = ActivityObjetoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.mensaje.isGone = true
        binding.mensajeBueno.isGone = true



        // Esto es del ejercicio 11, creamos Mochila_Articulo.kt donde estarán las clases Mochila y Articulo y creamos una mochila


        binding.boton1.setOnClickListener{
            // Esto es del ejercicio 11, mete el pico en la mochila

            try {

                if (personaje_1.getMochila().getPesoMochila() > 0 ) {
                    personaje_1.getMochila().addArticulo(Articulo("Pico", 5, 10, 20))
                    binding.boton1.isGone = true
                    binding.mensajeBueno.isGone = false
                }
                else
                    binding.mensaje.isGone = false

            }catch (EE:Exception) {
                println(EE)
            }

        }

        binding.boton2.setOnClickListener{
            binding.mensaje.isGone = true
            binding.mensajeBueno.isGone = true
            binding.boton1.isGone = false
            if (personaje_1.getLugar() == "Ciudad")
                funcionAleatoria()
            else {
                val intent = Intent(this, MainActivity_2::class.java)
                startActivity(intent)
            }


        }
    }
    private fun funcionAleatoria() {
        var aux = (1..3).random()

        if (aux == 1){
            val intent = Intent(this, Objeto::class.java)
            startActivity(intent)
        }else {
            if (aux == 2){
                val intent = Intent(this, Mercader::class.java)
                startActivity(intent)
            }else {
                val intent = Intent(this, Enemigo::class.java)
                startActivity(intent)
            }
        }

    }
}