package com.example.ejercicio_13_combatee

import java.io.Serializable

class Articulo(private var id:String, private var peso:Int, private var valor:Int, private var vida:Int) :Serializable{

    fun getPeso():Int{
        return peso
    }
    fun getValor():Int{
        return valor
    }
    fun getId():String{
        return id
    }
    fun getVida():Int{
        return vida
    }
    override fun toString(): String {
        return "[ID:$id, Peso:$peso, Valor:$valor, Vida:$vida]"
    }
}

class Mochila(private var pesoMochila: Int): Serializable {
    private var contenido=ArrayList<Articulo>()

    fun getPesoMochila():Int{
        return pesoMochila
    }
    fun addArticulo(articulo:Articulo){
        if (articulo.getPeso()<=pesoMochila){
            contenido.add(articulo)
            this.pesoMochila-=articulo.getPeso()
        }else{
            println("La mochila está llena, debes vender artículos")
        }
        println("Peso restante de la Mochila: "+pesoMochila)

    }
    fun getContenido(): ArrayList<Articulo> {
        return contenido
    }
    fun findObjeto(id: String):Int{
        for((indice,item) in contenido.withIndex()){
            if (item.getId() == id) {
                return indice
            }
        }
        return -1
    }

    override fun toString(): String {
        return "Mochila(pesoMochila=$pesoMochila, contenido=$contenido)"
    }



}