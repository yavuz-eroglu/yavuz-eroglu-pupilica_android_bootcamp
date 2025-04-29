package com.yavuzeroglu.tasarimcalismasi

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // R (kotlin sınıfları içerisinde) = res klasörü
        // @ (xml sınıfları içerisinde)= res klasörüdür.
        // <item name="android:statusBarColor">@color/anaRenk</item>

    }
}