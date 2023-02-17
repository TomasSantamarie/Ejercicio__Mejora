package com.example.ejercicio_13_combatee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio_13_combatee.databinding.ActivityMain2Binding

class MainActivity_2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.dado.setOnClickListener{ funcionAleatoria()}

        binding.guardar.setOnClickListener{
            val intent = Intent(this, Datos_personaje::class.java).apply {
                putExtra("Pagina","Principal")
            }
            startActivity(intent)
        }


    }

    private fun funcionAleatoria() {
        var aux = (1..4).random()
        if (aux == 1){
            val intent = Intent(this, Objeto::class.java)
            startActivity(intent)
        }else {
            if (aux == 2){
                val intent = Intent(this, Ciudad::class.java)
                startActivity(intent)
            }else {
                if (aux == 3){
                    val intent = Intent(this, Mercader::class.java)
                    startActivity(intent)
                }else {
                    val intent = Intent(this, Enemigo::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}