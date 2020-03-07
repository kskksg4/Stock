package com.example.stock.storeLocation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.stock.adapter.StoreAdapter
import com.example.stock.api.JSONApi

@Suppress("UNCHECKED_CAST")
class StoreLocationViewModelFactory(private val storeAdapter: StoreAdapter, private val api: JSONApi) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StoreLocationViewModel(storeAdapter, api) as T
    }

}