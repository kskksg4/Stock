package com.example.stock.store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.stock.api.JSONApi

@Suppress("UNCHECKED_CAST")
class StoreViewModelFactory(private val api: JSONApi) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StoreViewModel(api) as T
    }
}