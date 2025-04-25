package com.yavuzeroglu.kotlindersleri.degiskenler

import kotlin.reflect.typeOf

fun main() {
    var id=1
    var name = "Mont"
    var image = "mont.png"
    var points = 4.7
    var price = 4299
    var stockStatus = true

    println("$id \n $name \n $image \n $points \n $price \n $stockStatus")


    // Tür Dönüşümü
    val d = 86.48
    val i = 34

    val result1 = d.toInt()
    val result2 = i.toDouble()
    println(result1)
    println(result2)


    // 2- Sayısaldan metine donusturme.
    var x = 85
    val sonuc3 = x.toString() // "85"
    println(sonuc3)

    // 3- Metinden sayısala donusum.
    val yazi = "48"
    val sonuc4 = yazi.toInt()
    println(sonuc4)
}