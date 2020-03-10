package com.example.stock.storeDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.stock.adapter.StoreImageAdapter
import com.example.stock.api.JSONApi

@Suppress("UNCHECKED_CAST")
class DetailViewModelFactory(private val storeImageAdapter: StoreImageAdapter, private val api: JSONApi) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailViewModel(storeImageAdapter, api) as T
    }
}