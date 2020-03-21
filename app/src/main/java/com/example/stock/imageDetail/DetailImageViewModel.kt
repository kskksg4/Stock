package com.example.stock.imageDetail

import androidx.lifecycle.MutableLiveData
import com.example.stock.utils.BaseViewModel

class DetailImageViewModel : BaseViewModel() {

    val imgUrl = MutableLiveData<String>()

    fun setUrl(url: String){
        imgUrl.value = url
    }
}