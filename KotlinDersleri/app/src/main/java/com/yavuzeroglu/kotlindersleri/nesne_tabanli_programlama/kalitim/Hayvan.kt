package com.yavuzeroglu.kotlindersleri.nesne_tabanli_programlama.kalitim

open class Hayvan {
    open fun sesCikar() {
        println("Ses Çıkart")
    }
}

// override: Kalıtım ve üst sınıfın metodlarının alt sınıf tarafından tekrar kullanılmasıdır.
// override edilecek metod'a open kelimesi eklenmelidir.