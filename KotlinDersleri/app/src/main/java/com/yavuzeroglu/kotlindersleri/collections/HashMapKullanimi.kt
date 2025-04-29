package com.yavuzeroglu.kotlindersleri.collections

fun main() {
    // HashMap -> JSON veri modeline benzemektedir.
    // Key - Value veri modeli
    // farklı dillerde Map - Dictionary(Swift)
    // Shared Preferences, DataStore, UserDefault(Swift) benziyor.

    // Tanımlama

    val iller = HashMap<Int, String>()

    iller.put(16, "Bursa")
    iller.put(15, "Burdur")
    iller[34] = "İstanbul"
    iller[6] = "Ankara"
    println(iller)

    // Guncelleme
    iller[16] = "Yeni Bursa"

    for((anahtar, deger) in iller) {
        println("$anahtar - $deger")
    }
}