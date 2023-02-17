package com.example.ejercicio_13_combatee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ejercicio_13_combatee.databinding.ActivityDatosPersonajeBinding
import com.google.firebase.firestore.FirebaseFirestore

class Datos_personaje : AppCompatActivity() {
    private lateinit var binding: ActivityDatosPersonajeBinding
    private val db =FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_objeto)
        binding = ActivityDatosPersonajeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        datosPersonaje()
        val bundle = intent.extras
        val sitio = bundle?.getString("Pagina")


        binding.volver.setOnClickListener{
            sitioVolver(sitio)
        }
        binding.guardarEnBase.setOnClickListener{

            crear()

        }
    }

    private fun crear() {

        var partida = Partida(personaje_1)
        partidas.addPartida(partida)
        usuario.setPartidas(partidas)


        guardar()
    }

    private fun guardar() {
        db.collection("usuario_ejemplo").document(usuario.getCorreo()).set(usuario)

        val text = "Partida guardada!"
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()

    }

    private fun sitioVolver(sitio: String?) {
        if (sitio.equals("Ciudad")){
            val intent = Intent(this, Ciudad::class.java)
            startActivity(intent)
        }else{
            if (sitio.equals("Enemigo")){
                val intent = Intent(this, Enemigo::class.java)
                startActivity(intent)
            }else{
                if (sitio.equals("Principal")){
                    val intent = Intent(this, MainActivity_2::class.java)
                    startActivity(intent)
                }else{
                    if (sitio.equals("Mercader")){
                        val intent = Intent(this, Mercader::class.java)
                        startActivity(intent)
                    }
                }
            }
        }


    }

    private fun datosPersonaje() {
        binding.nombreDato.text= personaje_1.getNombre()
        binding.vidaDato.text= personaje_1.getVida().toString()
        binding.fuerzaDato.text= personaje_1.getFuerza().toString()
        binding.defensaDato.text= personaje_1.getDefensa().toString()
        binding.lugarDato.text= personaje_1.getLugar()
        binding.monedasDato.text= personaje_1.getMonedero().toString()
        binding.matadosDatos.text= personaje_1.getMatados().toString()
        binding.contadorArticulos.text= personaje_1.getMochila().getContenido().count().toString()
        binding.claseDato.text= personaje_1.getClase()
        binding.razaDato.text= personaje_1.getRaza()
        binding.pesoDato.text= personaje_1.getMochila().getPesoMochila().toString()
    }
}