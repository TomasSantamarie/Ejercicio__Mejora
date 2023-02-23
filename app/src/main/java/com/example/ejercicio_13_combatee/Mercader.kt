package com.example.ejercicio_13_combatee

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import com.example.ejercicio_13_combatee.databinding.ActivityMercaderBinding

class Mercader : AppCompatActivity() {
    private lateinit var binding: ActivityMercaderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_objeto)
        binding = ActivityMercaderBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var dinero = binding.dinero.text.toString().toInt()
        // Botones (Comprar, Vender y Cancelar)
        binding.botonesSecundarios.isGone = true

        // Esto es para el boton comprar
        //Objeto ( los text del objeto y poner cuantos quieres)
        binding.objeto.isGone = true

        // Esto es para el boton vender
        //mochila son los objetos que vas a vender | Objetos sera la cantidad que quiera vender el usuario | Mensaje el mensaje que puede aparecer
        binding.mochila.isGone = true
        binding.objetos.text = mochila.getContenido().count().toString()
        binding.mensajeUsuario.isGone = true

        // Acciones de los dos botones
        binding.comerciar.setOnClickListener {
            comerciar()
        }
        binding.cancelar.setOnClickListener {
            cancelar()
        }
        binding.continuar.setOnClickListener {
            if (usuario.getPartidas().getListaPartidas()[number].getPersonaje()
                    .getLugar() == "Ciudad"
            )
                funcionAleatoria()
            else {
                val intent = Intent(this, MainActivity_2::class.java)
                startActivity(intent)
            }
        }
        binding.comprar.setOnClickListener {
            comprar()
        }
        binding.vender.setOnClickListener {
            vender()
        }

        // Esto es cuando pongas la cantidad de objetos que quieres coprar
        //te va calculando cuanto le costara ( el usuario solo puene poner numeros)
        binding.trueCantidad.addTextChangedListener( object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                calcular(dinero)


            } })

        binding.cantidad.addTextChangedListener( object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.cantidad.text.toString().isNotEmpty())
                    binding.vender.isEnabled = personaje_1.getMochila().getContenido()
                        .count() >= binding.cantidad.text.toString().toInt()
                else
                    binding.vender.isEnabled = true
            } })

        binding.guardar.setOnClickListener{
            val intent = Intent(this, Datos_personaje::class.java).apply {
                putExtra("Pagina","Mercader")
            }
            startActivity(intent)
        }
    }


    private fun calcular(dinero: Int) {

        try {
            var multiplicador = binding.trueCantidad.text.toString().toInt()

            var aux = dinero * multiplicador
            binding.dinero.text = aux.toString()

            if (binding.cantidad.text.toString().isNotEmpty()){
                binding.comprar.isEnabled = personaje_1.getMochila().getPesoMochila() >= multiplicador*5 && personaje_1.getMonedero() >= multiplicador*125
            }else
                binding.comprar.isEnabled = true
        }catch (EE:Exception){
            println(EE)
        }
    }

    //Si se pulsa "Comerciar", se ejecutará la función "comerciar " que ocultará los botones (Comerciar, Continuar) y aparecerán
    // tres nuevos botones (Comprar, Vender y Cancelar).
    private fun comerciar() {

        binding.botonesPrincipales.isGone = true
        binding.guardar.isGone=true

        binding.botonesSecundarios.isGone = false



    }

    private fun cancelar(){
        binding.botonesPrincipales.isGone = false
        binding.guardar.isGone=false
        binding.botonesSecundarios.isGone = true
        binding.objeto.isGone = true
        binding.mochila.isGone = true
        binding.mensajeUsuario.isGone = true
        binding.comprar.isEnabled = false
        binding.imagen.setImageResource(0)

    }
    private fun comprar(){

        binding.objeto.isGone = false
        binding.imagen.setImageResource(R.drawable.espada)
        binding.mochila.isGone = true
        binding.mensajeUsuario.isGone = true
        binding.vender.isEnabled = true


        for(i in 1..binding.trueCantidad.text.toString().toInt()){
            personaje_1.getMochila().addArticulo(Articulo("Objeto",5,10,20))
            personaje_1.setMonedero(personaje_1.getMonedero()-125)
        }

        binding.trueCantidad.text = binding.cantidad.text





    }
    private fun vender() {
        binding.comprar.isEnabled = true
        binding.objeto.isGone = true
        binding.imagen.setImageResource(R.drawable.mochila)


        binding.objetos.text = personaje_1.getMochila().getContenido().count().toString()

        if (personaje_1.getMochila().getContenido().isEmpty()) {
            binding.mensajeUsuario.isGone = false
            binding.mochila.isGone = true
        }
        else {
            binding.mochila.isGone = false

            for (i in 1..binding.cantidad.text.toString().toInt()) {
                usuario.getPartidas().getListaPartidas()[number].getPersonaje().setMonedero(
                    personaje_1.getMonedero() + personaje_1.getMochila()
                        .getContenido()[0].getValor()
                )
                personaje_1.getMochila().deleteArticulo()
            }

        }

        if (personaje_1.getMochila().getContenido().isEmpty()) {
            binding.mensajeUsuario.isGone = false
            binding.mochila.isGone = true
        }
        binding.objetos.text = personaje_1.getMochila().getContenido().count().toString()
        binding.cantidad.text = binding.trueCantidad.text

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