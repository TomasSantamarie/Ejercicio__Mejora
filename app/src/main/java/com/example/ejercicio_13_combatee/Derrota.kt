package com.example.ejercicio_13_combatee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio_13_combatee.databinding.ActivityBinding
import com.example.ejercicio_13_combatee.databinding.ActivityCiudadBinding
import com.example.ejercicio_13_combatee.databinding.ActivityDerrotaBinding

class Derrota : AppCompatActivity() {
    private lateinit var binding: ActivityDerrotaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_derrota)
        binding = ActivityDerrotaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.comenzar.setOnClickListener{
            val intent = Intent(this, MainActivity_2::class.java)
            startActivity(intent)
        }

    }
}