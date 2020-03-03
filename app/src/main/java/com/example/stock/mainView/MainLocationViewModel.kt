package com.example.stock.mainView

import android.app.Application
import android.content.Intent
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.stock.storeLocation.StoreLocationActivity

class MainLocationViewModel(application: Application) : AndroidViewModel(application){

    var mainLocationText: ObservableField<String> = ObservableField("내 주변의 가게 찾기")

    fun clickIntent(view: View){
        val intent = Intent(view.context, StoreLocationActivity::class.java)
        view.context.startActivity(intent)
    }
}