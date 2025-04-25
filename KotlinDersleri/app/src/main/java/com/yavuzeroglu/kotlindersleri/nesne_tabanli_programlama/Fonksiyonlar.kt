package com.yavuzeroglu.kotlindersleri.nesne_tabanli_programlama

class Fonksiyonlar {
    // void : Sadece islem yapan.
    fun greeting1() { // Swift: func
        val sonuc = "Merhaba Yavuz"
        println(sonuc)
    }

    // return - hem islem yapan hem de veri transferi yapan
    fun greeting2(): String {
        val sonuc = "Merhaba Yavuz"
        return sonuc
    }


    // parametre
    fun greeting3(name: String) { // Swift: func
        val sonuc = "Merhaba $name"
        println(sonuc)
    }

    // Overloading
    // Bir sınıf içerisinde aynı isimde fonksiyonları tekrar kullanmak.
    fun topla(sayi1: Int, sayi2: Int) {
        println("Toplama: ${sayi1 + sayi2}")
    }

    fun topla(sayi1: Double, sayi2: Double) {
        println("Toplama: ${sayi1 + sayi2}")
    }

    fun topla(sayi1: Int, sayi2: Int, name: String) {
        println("Toplama: ${sayi1 + sayi2} - $name")
    }
}