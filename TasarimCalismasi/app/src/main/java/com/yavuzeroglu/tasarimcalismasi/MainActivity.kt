package com.yavuzeroglu.tasarimcalismasi

import android.content.SharedPreferences
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Switch
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var themeSwitch: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // R (kotlin sınıfları içerisinde) = res klasörü
        // @ (xml sınıfları içerisinde)= res klasörüdür.
        // <item name="android:statusBarColor">@color/anaRenk</item>

        // Karanlık mod ayarları
        sharedPreferences = getSharedPreferences("themeRef", MODE_PRIVATE)
        val isDarkMode = sharedPreferences.getBoolean("dark_mode", false)
        AppCompatDelegate.setDefaultNightMode(
            if (isDarkMode) AppCompatDelegate.MODE_NIGHT_YES
            else AppCompatDelegate.MODE_NIGHT_NO
        )

        themeSwitch = findViewById<Switch>(R.id.themeSwitch) as Switch
        themeSwitch.isChecked = isDarkMode

        themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            val editor = sharedPreferences.edit()
            editor.putBoolean("dark_mode", isChecked)
            editor.apply()

            AppCompatDelegate.setDefaultNightMode(
                if (isChecked) AppCompatDelegate.MODE_NIGHT_YES
                else AppCompatDelegate.MODE_NIGHT_NO
            )
            // Animasyon
            // DEPRECATED => overridePendingTransition(
            // android.R.anim.fade_in,
            // android.R.anim.fade_out)
            Handler(Looper.getMainLooper()).postDelayed({
                recreate()
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

            }, 10000)
        }
    }
}
