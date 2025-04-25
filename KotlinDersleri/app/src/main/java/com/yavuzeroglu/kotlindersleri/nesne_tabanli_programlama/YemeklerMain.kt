package com.yavuzeroglu.kotlindersleri.nesne_tabanli_programlama

fun main() {
    // Nesne olusturma

    val y1 = Yemekler(1, "Köfte", 249.99)

    // Deger okuma
    println("----------")
    println("Id: ${y1.id} Adı: ${y1.name} Fiyatı: ${y1.price}")


    val y2 = Yemekler(2, "Baklava", 300.00)
    println("----------")
    println("Id: ${y2.id} Adı: ${y2.name} Fiyatı: ${y2.price}")

    y2.name = "Soguk Baklava"
    println("Id: ${y2.id} Adı: ${y2.name} Fiyatı: ${y2.price}")


    println("----------")
    y1.bilgiAl()

    println("-----------")
    y2.bilgiAl()

}