package com.yavuzeroglu.kotlindersleri.nesne_tabanli_programlama

data class Yemekler(var id: Int, var name: String, var price: Double) {
    // constructor - init metodu
    // Bu sınıftan nesne olusturuldugunda calissin.

    init {
        println("***** Yemek Nesnesi Olusturuldu. *****")
    }

    fun bilgiAl() {
        println("--------")
        println("Id: ${this.id}   Ad: ${this.name}   Ücret: ${this.price}")
    }
}


// this: Bulundugu sınıfı temsil eder. --Swift = self
// super: Kalıtım ile bir üst sınıfı temsil eder.