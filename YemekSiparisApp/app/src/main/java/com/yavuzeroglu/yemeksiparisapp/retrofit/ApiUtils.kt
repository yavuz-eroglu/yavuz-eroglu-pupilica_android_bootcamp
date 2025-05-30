package com.yavuzeroglu.yemeksiparisapp.retrofit

import retrofit2.create

class ApiUtils {
    companion object {
        val BASE_URL = "http://kasimadalan.pe.hu"

        fun getYemekDao(): YemekDao {
            return RetrofitClient
                .getClient(BASE_URL)
                .create(YemekDao::class.java)
        }
    }
}