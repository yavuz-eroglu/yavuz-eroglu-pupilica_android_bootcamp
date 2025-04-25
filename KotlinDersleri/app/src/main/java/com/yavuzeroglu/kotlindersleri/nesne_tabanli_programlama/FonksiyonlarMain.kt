package com.yavuzeroglu.kotlindersleri.nesne_tabanli_programlama

fun main() {
    val f = Fonksiyonlar()

    // void - Unit
    f.greeting1()

    // return
    val gelenSonuc = f.greeting2()
    println("Gelen Sonuc: $gelenSonuc")

    // parametre
    f.greeting3("Fatma")


    f.topla(20, 12, "Yavuz")
}