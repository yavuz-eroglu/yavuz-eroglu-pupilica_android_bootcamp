package com.yavuzeroglu.kotlindersleri

fun main() {
    // 1.Compile Error : Kodlama yaparken oluşur.
    // val sayi = 100
    // sayi = 500


    // 2. Runtime Error : (Exceptions)
    val x = 10
    val y = 0

    println("Sonuc: ${x/y}")
    println("İslem Tamamlandı")

    try {
        println("Sonuc: ${x/y}")
        println("İslem Tamamlandı")
    } catch (e: Exception) {
        println("İkinci Sayi 0 olamaz.")
    }
}