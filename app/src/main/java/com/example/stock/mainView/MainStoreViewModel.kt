package com.example.stock.mainView

import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.stock.R
import com.example.stock.TestActivity
import com.example.stock.databinding.StoreActivityBinding
import com.example.stock.store.StoreActivity
import kotlin.reflect.KClass

class MainStoreViewModel(application: Application) : AndroidViewModel(application) {

    var mainStoreText: ObservableField<String> = ObservableField("영업중인 가게 찾기")

    fun clickIntent(view: View){
        val intent = Intent(view.context, StoreActivity::class.java)
        view.context.startActivity(intent)
    }
}