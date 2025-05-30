package com.yavuzeroglu.yemeksiparisapp.data.entity

import java.io.Serializable

data class CartItem(
    var sepet_yemek_id: String,
    var yemek_adi: String,
    var yemek_resim_adi: String,
    var yemek_fiyat: String,
    var yemek_siparis_adet: String,
    var kullanici_adi: String
) : Serializable