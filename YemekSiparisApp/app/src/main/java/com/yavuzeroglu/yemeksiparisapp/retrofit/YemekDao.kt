package com.yavuzeroglu.yemeksiparisapp.retrofit

import com.yavuzeroglu.yemeksiparisapp.data.entity.CRUDResponse
import com.yavuzeroglu.yemeksiparisapp.data.entity.CartItemResponse
import com.yavuzeroglu.yemeksiparisapp.data.entity.YemekResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface YemekDao {

    // http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php

    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun loadFoods(): YemekResponse

    @POST("yemekler/tumYemekleriGetir.php")
    @FormUrlEncoded
    suspend fun search(@Field("yemek_adi") searchQuery: String): YemekResponse

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    suspend fun addToCart(
        @Field("yemek_adi") yemek_adi: String,
        @Field("yemek_resim_adi") yemek_resim_adi: String,
        @Field("yemek_fiyat") yemek_fiyat: Int,
        @Field("yemek_siparis_adet") yemek_siparis_adet: Int,
        @Field("kullanici_adi") kullanici_adi: String
    ): CRUDResponse


    //    http://kasimadalan.pe.hu/yemekler/sepettekiYemekleriGetir.php
    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    suspend fun getCartItems(@Field("kullanici_adi") kullanici_adi: String): CartItemResponse


    //    http://kasimadalan.pe.hu/yemekler/sepettenYemekSil.php
    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    suspend fun deleteCartItem(@Field("sepet_yemek_id") sepet_yemek_id: Int,
                               @Field("kullanici_adi") kullanici_adi: String) : CRUDResponse
}