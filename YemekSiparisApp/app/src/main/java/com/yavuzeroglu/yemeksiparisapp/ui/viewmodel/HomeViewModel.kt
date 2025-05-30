package com.yavuzeroglu.yemeksiparisapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yavuzeroglu.yemeksiparisapp.data.entity.Yemek
import com.yavuzeroglu.yemeksiparisapp.data.repo.YemekRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(var yemekRepository: YemekRepository) : ViewModel() {

    var yemekList = MutableLiveData<List<Yemek>>()

    init {
        loadFoods()
    }

    fun loadFoods() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                yemekList.value = yemekRepository.loadFoods()
            } catch (e: Exception) {
            }
        }
    }

    fun search(searchQuery: String) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                yemekList.value = yemekRepository.search(searchQuery)
            } catch (e: Exception) {
            }
        }
    }


}