package com.example.ejercicio_13_combatee

import java.io.Serializable

class Personaje(
    private var nombre: String,
    private var vida: Int,
    private var fuerza: Int,
    private var defensa: Int,
    private var mochila: Mochila,
    private var monedero: Int,
    private var lugar: String,
    private var matados: Int,
    private var clase: String,
    private var raza: String
) : Serializable {

    constructor() : this("", 0, 0, 0, Mochila(), 0, "", 0, "", "") {

    }

    fun getNombre(): String {
        return nombre
    }

    fun setNombre(aux: String) {
        nombre = aux
    }

    fun getVida(): Int {
        return vida
    }

    fun setVida(aux: Int) {
        vida = aux
    }

    fun getFuerza(): Int {
        return fuerza
    }

    fun setFuerza(aux: Int) {
        fuerza = aux
    }

    fun getDefensa(): Int {
        return defensa
    }

    fun setDefensa(aux: Int) {
        defensa = aux
    }

    fun getMochila(): Mochila {
        return mochila
    }

    fun getMonedero(): Int {
        return monedero
    }

    fun setMonedero(aux: Int) {
        monedero = aux
    }

    fun getLugar(): String {
        return lugar
    }

    fun setLugar(aux: String) {
        lugar = aux
    }

    fun getMatados(): Int {
        return matados
    }

    fun setMatados(aux: Int) {
        matados = aux
    }

    fun getClase(): String {
        return clase
    }

    fun setClase(aux: String) {
        clase = aux
    }

    fun getRaza(): String {
        return raza
    }

    fun setRaza(aux: String) {
        raza = aux
    }

    override fun toString(): String {
        return "[Personaje{ Nombre: ${nombre}, Vida:${vida}, Fuerza:${fuerza}, Defensa:${defensa}, Mochila:${mochila}, Monedero: ${monedero} }]"
    }
}

var number = 0
var mochila = Mochila(200)
var personaje_1 = Personaje("", 0, 0, 0, mochila, 0, "Bosque", 0, "", "")