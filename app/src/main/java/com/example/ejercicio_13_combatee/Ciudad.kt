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

        binding.botonc1.setOnClickListener{
            val intent = Intent(this, MainActivity_2::class.java)
            startActivity(intent)
        }

        binding.botonc2.setOnClickListener{
            val intent = Intent(this, MainActivity_2::class.java)
            startActivity(intent)
        }
    }
}