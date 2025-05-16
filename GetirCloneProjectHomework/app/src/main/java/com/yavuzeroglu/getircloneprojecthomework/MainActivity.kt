package com.yavuzeroglu.getircloneprojecthomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yavuzeroglu.getircloneprojecthomework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sliderImages = listOf(
            R.drawable.promotion_1,
            R.drawable.promotion_2,
            R.drawable.promotion_3,
            R.drawable.promotion_4
        )

        binding.imageSlider.adapter = SliderAdapter(sliderImages)
    }
}