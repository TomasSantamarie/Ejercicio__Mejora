package com.example.ejercicio_13_combatee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isGone
import com.example.ejercicio_13_combatee.databinding.ActivityEnemigoBinding

class Enemigo : AppCompatActivity() {
    private lateinit var binding: ActivityEnemigoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_objeto)
        binding = ActivityEnemigoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.vidaEnemigo.isGone = true
        binding.vidaUsuario.isGone = true
        binding.botonesSecundarios.isGone = true
        binding.normal.isGone = true
        binding.boss.isGone = true


        

        var nivel_enemigo = (1..2).random()
        binding.luchar.setOnClickListener{
            // Hacerlo solo una vez tienden a dar el mismo resultado o con una alta probabilidad
            nivel_enemigo = (1..2).random()
            combate(nivel_enemigo)

        }

        binding.huir.setOnClickListener{
            huirUsuario()
            nivel_enemigo = (1..2).random()
        }

        binding.atacar.setOnClickListener{
            ataqueUsuario(nivel_enemigo)
            ataqueEnemigo(nivel_enemigo)
        }

        binding.huirDado.setOnClickListener{
            huirRandom(nivel_enemigo)

        }
        binding.objetoVida.setOnClickListener{
            usarObjeto()
        }
    }

    private fun usarObjeto() {
        try {
            if (personaje_1.getMochila().getContenido().isNotEmpty() && binding.VidaProgresUsuario.progress < 200){
                personaje_1.getMochila().getContenido().removeAt(0)
                if ((binding.VidaProgresUsuario.progress + 20) > 200)
                    binding.VidaProgresUsuario.progress = 200
                else
                    binding.VidaProgresUsuario.progress += 20

            }else{
                var text = personaje_1.getMochila().getContenido().toString()
                val duration = Toast.LENGTH_SHORT
                var toast = Toast.makeText(applicationContext, text, duration)

                if (personaje_1.getMochila().getContenido().isEmpty()){
                    text = "No tienes objetos!"
                    toast = Toast.makeText(applicationContext, text, duration)
                    toast.show()
                }

                if (binding.VidaProgresUsuario.progress == 200){
                     text = "Tienes toda la vida!"

                     toast = Toast.makeText(applicationContext, text, duration)
                    toast.show()
                }

            }
        }catch (EE:Exception){
            println(EE)
        }
    }

    private fun huirRandom(nivel_enemigo: Int) {
        var dado = (1..6).random()
        // Hacerlo solo una vez tienden a dar el mismo resultado o con una alta probabilidad
        dado = (1..6).random()
        if (dado>=5){
            huirUsuario()
        }else{
            val text = "No pudiste huir!"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
            ataqueEnemigo(nivel_enemigo)
        }
    }

    private fun huirUsuario() {
        binding.VidaProgresUsuario.progress = 200
        binding.VidaProgresUsuario.progress = 200
        binding.luchar.isGone=false
        binding.vidaEnemigo.isGone = true
        binding.vidaUsuario.isGone = true
        binding.botonesSecundarios.isGone = true
        binding.boss.isGone = true
        binding.normal.isGone = true
        binding.huir.text = "HUIR"
        val intent = Intent(this, MainActivity_2::class.java)
        startActivity(intent)
    }

    private fun ataqueUsuario(nivel_enemigo: Int) {
        val dado = (1..6).random()

        if (dado>=4){

            if (nivel_enemigo == 1) {
                if (binding.VidaProgresEnemigo.min >= (binding.VidaProgresEnemigo.progress - ((personaje_1.getFuerza()) * 2)))
                    binding.VidaProgresEnemigo.progress = binding.VidaProgresEnemigo.min
                else
                    binding.VidaProgresEnemigo.progress -= (personaje_1.getFuerza()) * 2

            } else {
                if (binding.VidaProgresEnemigo.min >= (binding.VidaProgresEnemigo.progress - personaje_1.getFuerza()))
                    binding.VidaProgresEnemigo.progress = binding.VidaProgresEnemigo.min
                else
                    binding.VidaProgresEnemigo.progress -= (personaje_1.getFuerza())
            }
            if (binding.VidaProgresEnemigo.progress == binding.VidaProgresEnemigo.min)
                victoria(nivel_enemigo)
        }else{
            val text = "Fallaste!"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()

        }

    }

    private fun victoria(nivel_enemigo: Int) {
        binding.vidaEnemigo.isGone = true
        binding.vidaUsuario.isGone = true
        binding.botonesSecundarios.isGone = true
        binding.botonesPrincipales.isGone = false
        binding.luchar.isGone=true
        binding.huir.text = "CONTINUAR"
        binding.enemigo.setImageResource(0)

        if (nivel_enemigo==1)
            binding.normal.isGone =true
        else
            binding.boss.isGone = true

        val text = "Has Ganado! Continua tu aventura"
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }

    private fun ataqueEnemigo(nivel_enemigo: Int) {
        if (nivel_enemigo == 1) {

            if (binding.VidaProgresUsuario.min >= (binding.VidaProgresUsuario.progress - (20 / personaje_1.getDefensa())))
                binding.VidaProgresUsuario.progress = binding.VidaProgresUsuario.min
            else
                binding.VidaProgresUsuario.progress -= 20 / personaje_1.getDefensa()
        } else {
            if (binding.VidaProgresUsuario.min >= (binding.VidaProgresUsuario.progress - (30 / personaje_1.getDefensa())))
                binding.VidaProgresUsuario.progress = binding.VidaProgresUsuario.min
            else
                binding.VidaProgresUsuario.progress -= 30 / personaje_1.getDefensa()
        }
        if (binding.VidaProgresUsuario.progress == binding.VidaProgresUsuario.min)
            derrota()
    }

    private fun derrota() {
        try {

            binding.VidaProgresUsuario.progress = 200
            binding.VidaProgresUsuario.progress =200
            binding.luchar.isGone=false
            binding.vidaEnemigo.isGone = true
            binding.vidaUsuario.isGone = true
            binding.botonesSecundarios.isGone = true
            binding.botonesPrincipales.isGone=false
            binding.enemigo.setImageResource(0)
            binding.boss.isGone = true
            binding.normal.isGone = true

            val intent = Intent(this, Derrota::class.java)
            startActivity(intent)
        }catch (EE:Exception){
        println(EE)
    }

    }

    private fun combate(nivel_enemigo: Int) {
        binding.vidaEnemigo.isGone = false
        binding.vidaUsuario.isGone = false
        binding.botonesSecundarios.isGone = false
        binding.botonesPrincipales.isGone = true
        binding.enemigo.setImageResource(R.drawable.goblin)

        if (nivel_enemigo==1)
            binding.normal.isGone =false
        else
            binding.boss.isGone = false
    }
}