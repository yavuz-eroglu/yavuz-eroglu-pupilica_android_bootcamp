package com.yavuzeroglu.yemeksiparisapp.data.repo

import com.yavuzeroglu.yemeksiparisapp.data.datasource.YemekDataSource
import com.yavuzeroglu.yemeksiparisapp.data.entity.CRUDResponse
import com.yavuzeroglu.yemeksiparisapp.data.entity.Yemek
import retrofit2.http.Field

class YemekRepository(var yemekDataSource: YemekDataSource) {

    suspend fun loadFoods(): List<Yemek> = yemekDataSource.loadFoods()

    suspend fun search(searchQuery: String) = yemekDataSource.search(searchQuery)

    suspend fun addToCart(
        yemek_adi: String,
        yemek_resim_adi: String,
        yemek_fiyat: Int,
        yemek_siparis_adet: Int,
        kullanici_adi: String
    ) = yemekDataSource.addToCart(
        yemek_adi,
        yemek_resim_adi,
        yemek_fiyat,
        yemek_siparis_adet,
        kullanici_adi
    )

    suspend fun getCartItems(kullanici_adi: String) = yemekDataSource.getCartItems(kullanici_adi)

    suspend fun deleteCartItem(sepet_yemek_id: Int, kullanici_adi: String) = yemekDataSource.deleteCartItem(sepet_yemek_id, kullanici_adi)
}