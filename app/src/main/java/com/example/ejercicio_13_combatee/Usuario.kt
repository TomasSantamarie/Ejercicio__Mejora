package com.example.ejercicio_13_combatee

import java.io.Serializable

class Usuario(private var correo: String) : Serializable {
    private var partidas = Partidas()

    constructor() : this("") {

    }

    fun getCorreo(): String {
        return correo
    }

    fun setCorreo(aux: String) {
        correo = aux
    }

    fun setPartidas(aux: Partidas) {
        partidas = aux
    }

    fun getPartidas(): Partidas {
        return partidas
    }
}

class Partidas() : Serializable {
    private var listaPartidas = ArrayList<Partida>()
    fun getListaPartidas(): ArrayList<Partida> {
        return listaPartidas
    }

    fun encontrarPartida(nombre_personaje: String): Int {
        for ((indice, item) in listaPartidas.withIndex()) {
            if (item.getNombrePersonaje() == nombre_personaje) {
                return indice
            }
        }
        return -1
    }

    fun eliminarPartida(i: Int) {
        if (listaPartidas.isNotEmpty()) {
            getListaPartidas().removeAt(i)
        }
    }

    fun addPartida(partida: Partida) {
        listaPartidas.add(partida)
    }
}

class Partida(private var personaje: Personaje, private var nombre_personaje: String) :
    Serializable {

    constructor() : this(Personaje(), "")

    fun getNombrePersonaje(): String {
        return nombre_personaje
    }

    fun getPersonaje(): Personaje {
        return personaje
    }

    fun setNombrePersonaje(name: String) {
        this.nombre_personaje = name
    }

    fun setPersonaje(personaje: Personaje) {
        this.personaje = personaje
    }


}

var usuario = Usuario("ejemplo.ejemplo@gmail.com")
var partidas = Partidas()


