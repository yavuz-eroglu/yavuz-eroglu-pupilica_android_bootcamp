package com.yavuzeroglu.yemeksiparisapp.data.datasource

import android.util.Log
import com.yavuzeroglu.yemeksiparisapp.data.entity.CRUDResponse
import com.yavuzeroglu.yemeksiparisapp.data.entity.CartItem
import com.yavuzeroglu.yemeksiparisapp.data.entity.Yemek
import com.yavuzeroglu.yemeksiparisapp.retrofit.ApiUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.http.Field

class YemekDataSource {

    suspend fun loadFoods(): List<Yemek> = withContext(Dispatchers.IO) {
        val dao = ApiUtils.getYemekDao()
        val list = dao.loadFoods().yemekler
        return@withContext list
    }

    suspend fun search(searchQuery: String): List<Yemek> = withContext(Dispatchers.IO) {
        val dao = ApiUtils.getYemekDao()
        val result = dao.search(searchQuery).yemekler

        return@withContext result
    }

    suspend fun addToCart(
        yemek_adi: String,
        yemek_resim_adi: String,
        yemek_fiyat: Int,
        yemek_siparis_adet: Int,
        kullanici_adi: String
    ) {
        val dao = ApiUtils.getYemekDao()
        dao.addToCart(
            yemek_adi,
            yemek_resim_adi,
            yemek_fiyat,
            yemek_siparis_adet,
            kullanici_adi
        )
    }

    suspend fun deleteCartItem(sepet_yemek_id: Int,
                               kullanici_adi: String)  {
        val dao = ApiUtils.getYemekDao()
        dao.deleteCartItem(sepet_yemek_id, kullanici_adi)
    }
    suspend fun getCartItems(kullanici_adi: String) : List<CartItem> = withContext(Dispatchers.IO) {

        val dao = ApiUtils.getYemekDao()
        val list = dao.getCartItems(kullanici_adi).sepet_yemekler
        return@withContext list
    }
}