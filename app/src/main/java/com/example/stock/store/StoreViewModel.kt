package com.example.stock.store

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.stock.utils.BaseViewModel

class StoreViewModel : BaseViewModel(){

    var devText: ObservableField<String> = ObservableField("devText")
}