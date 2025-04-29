package com.yavuzeroglu.kotlindersleri.nesne_tabanli_programlama.kalitim

fun main() {
    val hayvan = Hayvan()
    val memeli = Memeli()
    val kopek = Kopek()
    val kedi = Kedi()

    hayvan.sesCikar() // Burada kalitim yok kendi metoduna erişti.
    memeli.sesCikar() // Kalitim var bir üst sınıfın metoduna erişti.
    kedi.sesCikar() //
    kopek.sesCikar()
}