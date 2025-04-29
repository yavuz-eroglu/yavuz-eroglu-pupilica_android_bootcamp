package com.yavuzeroglu.kotlindersleri.collections

fun main() {
    val f1 = Filmler(1, "Babam ve Oğlum", 50)
    val f2 = Filmler(2, "Neşeli Hayatlar", 30)
    val f3 = Filmler(3, "Kış Uykusu", 80)

    val filmList = ArrayList<Filmler>()
    filmList.add(f1)
    filmList.add(f2)
    filmList.add(f3)

    for (film in filmList) {
        println("${film.id} - ${film.name}- ${film.price}")
    }

    // sorting
    println("--- Fiyata göre artan ---")
    // ASC
    val siralama1 = filmList.sortedWith(compareBy { it.price })
    for (film in siralama1) {
        println("${film.id} - ${film.name}- ${film.price}")
    }

    println("--- Fiyata göre azalan ---")
    // DESC
    val siralama2 = filmList.sortedWith(compareByDescending { it.price })
    for (film in siralama2) {
        println("${film.id} - ${film.name}- ${film.price}")
    }

    // Filtreleme
    println("---------- Filtreleme - 1 ----------")
    val filtreleme1 = filmList.filter { it.price >= 50 && it.price < 100}

    for (film in filtreleme1) {
        println("${film.id} - ${film.name}- ${film.price}")
    }

    println("---------- Filtreleme - 1 ----------")
    val filtreleme2 = filmList.filter { it.name.contains("ba") }
    for (film in filtreleme2) {
        println("${film.id} - ${film.name}- ${film.price}")
    }
}