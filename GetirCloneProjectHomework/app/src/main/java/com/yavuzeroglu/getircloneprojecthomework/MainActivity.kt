package com.yavuzeroglu.getircloneprojecthomework

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.yavuzeroglu.getircloneprojecthomework.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val autoScrollHandler = Handler(Looper.getMainLooper())
    private lateinit var autoScrollRunnable: Runnable


    override fun onResume() {
        super.onResume()
        startAutoScroll()
    }

    override fun onPause() {
        super.onPause()
        stopAutoScroll()
    }

    val sliderImages = listOf(
        R.drawable.promotion_1,
        R.drawable.promotion_2,
        R.drawable.promotion_3,
        R.drawable.promotion_4
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val categoryList = listOf(
            Category("Atıştırmalık", R.drawable.atistirmalik),
            Category("Su, İçecek", R.drawable.su_icecek),
            Category("Meyve & Sebze", R.drawable.meyve_sebze),
            Category("Süt Ürünleri", R.drawable.sut_urunleri),
            Category("Kahvaltılık", R.drawable.kahvaltilik),
            Category("Fırından", R.drawable.firindan),
            Category("Dondurma", R.drawable.dondurma),
            Category("Temel Gıda", R.drawable.temel_gida),
            Category("Yiyecek", R.drawable.yiyecek),
            Category("Et, Balık, Tavuk", R.drawable.et_balik_tavuk),
            Category("Fit & Form", R.drawable.fit_form),
            Category("Kişisel Bakım", R.drawable.kisisel_bakim),
            Category("Ev Bakım", R.drawable.ev_bakim),
            Category("Ev Yaşam", R.drawable.ev_yasam),
            Category("Evcil Hayvan", R.drawable.evcil_hayvan)
        )

        binding.viewPager.adapter = SliderAdapter(sliderImages)
        binding.categoryRecyclerView.layoutManager = GridLayoutManager(this, 4)
        binding.categoryRecyclerView.adapter = CategoryAdapter(categoryList)




        binding.viewPager.setPageTransformer { page, position ->
            val offset = position * -(2 * 40 + 20) // padding + margin
            if (binding.viewPager.orientation == ViewPager2.ORIENTATION_HORIZONTAL) {
                page.translationX = offset
            } else {
                page.translationY = offset
            }
        }
    }

    private fun startAutoScroll() {
        autoScrollRunnable = object : Runnable {
            override fun run() {
                val currentItem = binding.viewPager.currentItem
                val nextItem = if (currentItem == sliderImages.size - 1) 0 else currentItem + 1
                binding.viewPager.setCurrentItem(nextItem, true)
                autoScrollHandler.postDelayed(this, 3000) // 3 saniyede bir
            }
        }
        autoScrollHandler.postDelayed(autoScrollRunnable, 3000)
    }

    private fun stopAutoScroll() {
        autoScrollHandler.removeCallbacks(autoScrollRunnable)
    }
}