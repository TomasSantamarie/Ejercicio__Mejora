package com.example.ejercicio_13_combatee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import com.example.ejercicio_13_combatee.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var aux = ""
        binding.Mago.setOnClickListener { cambioFoto(binding.Mago.text.toString())
            aux = "Mago"}

        binding.Ladron.setOnClickListener { cambioFoto(binding.Ladron.text.toString())
            aux = "Ladron"}

        binding.Berserker.setOnClickListener { cambioFoto(binding.Berserker.text.toString())
            aux = "Berserker"}

        binding.Guerrero.setOnClickListener { cambioFoto(binding.Guerrero.text.toString())
            aux = "Guerrero"}

        findViewById<Button>(R.id.aceptar).setOnClickListener{cambioPagina(aux)}
    }




    private fun cambioFoto(text: String){

        val imagen = binding.imageView

        if (text.equals("Guerrero"))
            imagen.setImageResource(R.drawable.guerrero)

        if (text.equals("Mago"))
            imagen.setImageResource(R.drawable.mago)

        if (text.equals("Berserker"))
            imagen.setImageResource(R.drawable.berserker)

        if (text.equals("Ladrón"))
            imagen.setImageResource(R.drawable.ladron)


    }
    private fun cambioPagina(aux: String) {

        val intent = Intent(this, SegundaPag::class.java).apply {
            putExtra("Clase",aux)
        }


        startActivity(intent)
    }


}