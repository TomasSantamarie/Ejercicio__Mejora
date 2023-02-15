package com.example.ejercicio_13_combatee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio_13_combatee.databinding.ActivityCiudadBinding

class Ciudad : AppCompatActivity() {
    private lateinit var binding: ActivityCiudadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_objeto)
        binding = ActivityCiudadBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.entrar.setOnClickListener{
            funcionAleatoria()
            personaje_1.setLugar("Ciudad")
            //binding.entrar.text= personaje_1.getLugar()


        }

        binding.seguir.setOnClickListener{
            val intent = Intent(this, MainActivity_2::class.java)
            startActivity(intent)
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