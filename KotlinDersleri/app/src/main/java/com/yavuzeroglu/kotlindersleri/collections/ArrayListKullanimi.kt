package com.yavuzeroglu.kotlindersleri.collections

fun main() {
    var meyveler = ArrayList<String>()


    // Veri Ekleme : listenin en sonuna ekleme yapar
    meyveler.add("Elma")
    meyveler.add("Muz")
    meyveler.add("Kiraz")
    println(meyveler)

    // Güncelleme
    meyveler[1] = "Yeni Muz"

    // Insert : istedigimiz yere ekleme
    meyveler.add(1, "Portakal")
    println(meyveler)

    // Okuma
    val m = meyveler.get(3)
    println(m)
    println(meyveler[3])


    println("Boyut : ${meyveler.size}")

    meyveler.reverse()
    println(meyveler)

    for(meyve in meyveler) {
        println("Sonuç $meyve")
    }


    for((index, meyve) in meyveler.withIndex()) { //Swift -> enumerated()
        println("$index -> $meyve")
    }

    // silme : removeAt
    meyveler.removeAt(1)
    println(meyveler)

    // Tüm listeyi silme
    meyveler.clear()
    println(meyveler)
}
