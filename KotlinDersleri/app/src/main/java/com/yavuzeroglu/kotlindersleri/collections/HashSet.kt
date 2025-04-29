package com.yavuzeroglu.kotlindersleri.collections

fun main() {
    // HashSet
    // Tanımlama
    // Any -> en üst sınıf demektir.
    val meyveler = HashSet<String>()

    meyveler.add("Elma")
    meyveler.add("Muz")
    meyveler.add("Kiraz")
    println(meyveler)


    println("${meyveler.elementAt(2)}")

    println("Boyut ${meyveler.size}")

    for(meyve in meyveler) {
        println("Sonuc: ${meyve}")
    }

    for((index, meyve) in meyveler.withIndex()) {
        println("$index - $meyve")
    }

    meyveler.remove("Elma")
    println(meyveler)
}