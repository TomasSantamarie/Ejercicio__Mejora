package com.example.ejercicio_13_combatee

import java.io.Serializable

class Usuario(private var correo:String) : Serializable {
    private var partidas = Partidas()
    fun getCorreo():String{
        return correo
    }
    fun setCorreo(aux:String){
        correo=aux
    }
    fun setPartidas(aux:Partidas){
        partidas=aux
    }
    fun getPartidas():Partidas{
        return partidas
    }
}

class Partidas(): Serializable {
    private var partidas = ArrayList<Partida>()
    fun getListaPartidas(): ArrayList<Partida>{
        return partidas
    }
    fun encontrarPartida(nombre_personaje: String): Int {
        for ((indice, item) in partidas.withIndex()) {
            if (item.getNombrePersonaje() == nombre_personaje) {
                return indice
            }
        }
        return -1
    }
    fun eliminarPartida(i: Int){
        if (partidas.isNotEmpty()) {
            getListaPartidas().removeAt(i)
        }
    }
    fun addPartida(partida: Partida){
        partidas.add(partida)
    }
}
class Partida(private var personaje: Personaje) : Serializable {
    private var nombre_personaje = personaje.getNombre()
    fun getNombrePersonaje():String{
        return nombre_personaje
    }

    fun getPersonaje():Personaje{
        return personaje
    }


}

var usuario = Usuario("ejemplo.ejemplo@gmail.com")
var partidas = Partidas()


