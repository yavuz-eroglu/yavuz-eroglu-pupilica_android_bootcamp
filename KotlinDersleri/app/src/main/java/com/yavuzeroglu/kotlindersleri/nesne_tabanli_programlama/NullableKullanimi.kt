package com.yavuzeroglu.kotlindersleri.nesne_tabanli_programlama

import java.util.Locale

fun main() {
    // Nullable, Null Safety, Optional(Swift)
    // Genellikle mobil uygulama gelistirme dillerinde yer almaktadir.
    // null, NaN, nil

    // 1. tanımlama
    var mesaj: String? = null

    mesaj = "merhaba"

    // Yöntem - 1
    // Sorun yoksa uygulama calisir. Çökme yaşanmaz.
    println("Yöntem - 1: ${mesaj?.uppercase()}") // Output: MERHABA

    val x = mesaj?.capitalize()

    // Yöntem - 2
    // Sorun yoksa çalışır, sorun varsa uygulama çöker.
    // Çok emin oldugunuz kodlarda çalışır.
//     println("Yöntem - 2: ${mesaj!!.uppercase()}")

    // Yöntem - 3
    // null kontrol
    if (mesaj != null){
        println("Yöntem - 3: ${mesaj.uppercase()}")
    } else {
        println("değişkende null yer almaktadır.")
    }

    // Yöntem - 4
    // null kontrol
    mesaj?.let {
        println("Yöntem - 4: ${mesaj.replaceFirstChar { it.uppercase() }}")
    }


}