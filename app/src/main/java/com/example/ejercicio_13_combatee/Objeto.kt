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

                var contador= mochila.getContenido().count()
                var aux = 0
                for (i in 1 .. contador){
                    aux += mochila.getContenido()[i-1].getPeso()
                }
                if (mochila.getPesoMochila() >= aux) {
                    personaje_1.getMochila().addArticulo(Articulo("Pico", 5, 10, 20))
                    binding.boton1.isGone = true
                    binding.mensajeBueno.isGone = false
                }
                else
                    binding.mensaje.isGone = false

            }catch (EE:Exception) {
                println(EE)
            }
            /*
            val intent = Intent(this, Blanco::class.java)
                intent.putExtra("Mochila",mochila)

            startActivity(intent)
             */

        }

        binding.boton2.setOnClickListener{
            binding.mensaje.isGone = true
            binding.mensajeBueno.isGone = true
            binding.boton1.isGone = false
            val intent = Intent(this, MainActivity_2::class.java)
            startActivity(intent)

        }
    }
}