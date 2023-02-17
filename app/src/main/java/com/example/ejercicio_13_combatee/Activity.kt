package com.example.ejercicio_13_combatee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.ejercicio_13_combatee.databinding.ActivityBinding
import com.example.ejercicio_13_combatee.databinding.ActivityMainBinding

class Activity : AppCompatActivity() {

    private lateinit var binding: ActivityBinding

    private lateinit var bindingMain: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        bindingMain= ActivityMainBinding.inflate(layoutInflater)
        binding.Comenzar.isEnabled = false
        val bundle = intent.extras
        val clase = bundle?.getString("Clase")
        val raza = bundle?.getString("Raza")

        cambioFoto(clase.toString())
        cambioFoto2(raza.toString())

        atributosAleatorios()

        binding.Volver.setOnClickListener{cambioPaginaVolver()}
        binding.Comenzar.setOnClickListener{cambioPaginaComenzar()}

        binding.Nombre.addTextChangedListener( object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                personaje_1.setNombre(binding.Nombre.text.toString())
                binding.Comenzar.isEnabled = binding.Nombre.text.toString().isNotEmpty()
            } })
    }

    private fun atributosAleatorios() {

        var aux = randon(10,15)
        binding.Fuerza.text = "Fuerza: "+aux
        personaje_1.setFuerza(aux)

        aux = randon(1,5)
        personaje_1.setDefensa(aux)
        binding.Defensa.text = "Defensa: "+aux

        aux = randon(200,200)
        personaje_1.setVida(aux)
        binding.Vida.text = "Vida: "+aux

        for(i in 1..personaje_1.getMochila().getContenido().count()){
            personaje_1.getMochila().deleteArticulo()
        }


        binding.TamaOMochila.text = "Tamaño Mochila: "+ mochila.getPesoMochila()

        aux = randon(0,0)
        personaje_1.setMonedero(aux)
        binding.Monedero.text = "Monedero: "+aux



        personaje_1.setMatados(0)
        personaje_1.setLugar("Bosque")

    }

    fun randon(start: Int, end: Int): Int {
        require(start <= end) { "Illegal Argument" }
        return (start..end).random()
    }
    private fun cambioFoto(text: String) {

        val imagen = binding.clase

        if (text.equals("Guerrero"))
            imagen.setImageResource(R.drawable.guerrero)

        if (text.equals("Mago"))
            imagen.setImageResource(R.drawable.mago)

        if (text.equals("Berserker"))
            imagen.setImageResource(R.drawable.berserker)

        if (text.equals("Ladron"))
            imagen.setImageResource(R.drawable.ladron)

    }
    private fun cambioFoto2(text: String) {

        val imagen = binding.raza

        if (text.equals("Humano"))
            imagen.setImageResource(R.drawable.humano)

        if (text.equals("Goblin"))
            imagen.setImageResource(R.drawable.goblin)

        if (text.equals("Elfo"))
            imagen.setImageResource(R.drawable.elfo)

        if (text.equals("Enano"))
            imagen.setImageResource(R.drawable.enano)
    }

    private fun cambioPaginaVolver() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun cambioPaginaComenzar() {
        val intent = Intent(this, MainActivity_2::class.java)
        startActivity(intent)
    }



}