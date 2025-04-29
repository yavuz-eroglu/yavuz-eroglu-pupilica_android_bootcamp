package com.yavuzeroglu.kotlindersleri.nesne_tabanli_programlama

fun main() {
    val a = ClassA()

    // Standart nesne tabanli erisim
//    println(a.x)
//    a.metod()

    // Sanal nesne - Virtual object - Nameless(Isimsiz) Object
//    println(ClassA().x)
//    ClassA().metod()

    // companion object = static nesne
    // Static kullanimi.
    ClassA.x
    ClassA.metod()
}