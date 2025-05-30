package com.yavuzeroglu.yemeksiparisapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yavuzeroglu.yemeksiparisapp.data.entity.CartItem
import com.yavuzeroglu.yemeksiparisapp.data.repo.YemekRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(var yemekRepository: YemekRepository) : ViewModel() {
    var itemList = MutableLiveData<List<CartItem>>()

    init {
        getCartItems("yavuz_eroglu")
    }


    fun getCartItems(kullanici_adi: String) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                itemList.value = yemekRepository.getCartItems("yavuz_eroglu")
            } catch (e: Exception) {
            }
        }
    }

    fun deleteCartItem(sepet_yemek_id: Int, kullanici_adi: String) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                yemekRepository.deleteCartItem(sepet_yemek_id, "yavuz_eroglu")
                getCartItems("yavuz_eroglu")
            } catch (e: Exception) { }
        }
    }
}