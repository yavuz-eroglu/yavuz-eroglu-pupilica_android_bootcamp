package com.yavuzeroglu.kotlindersleri.standart_programlama

fun main() {
    val yas = 17

    println(yas >= 18)
    if(yas >= 18) {
        println("Reşitsiniz.")
    } else {
        println("Reşit Değilsiniz")
    }
    println("*********************")
    val ka = "admin1"
    val s = 123456
    val sayi = 10

    if(ka == "admin" && s == 123456) {
        println("Hoşgeldiniz")
    } else  {
        println("Kullanici adi veya sifre yanlis")
    }

    if(sayi == 9 || sayi == 10) {
        println("Sayi 9 veya 10'dur")
    } else {
        println("Sayi 9 veya 10 değildir")
    }
    println("**********************")
    // when, (diger dillerde switch)

    val number = 1
    when(number) {
        1 -> println("Sayi 1")
        2 -> {
            println("Sayi 2")
        }
        else -> println("Tanimlanmayan Sayi!")
    }
}