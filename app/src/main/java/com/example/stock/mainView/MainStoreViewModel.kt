package com.example.stock.mainView

import android.app.Application
import android.content.Intent
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import com.example.stock.store.StoreActivity

class MainStoreViewModel(application: Application) : AndroidViewModel(application) {

    var mainStoreText: ObservableField<String> = ObservableField("영업중인 가게 찾기")

    fun clickIntent(view: View){
        val intent = Intent(view.context, StoreActivity::class.java)
        view.context.startActivity(intent)
    }
}