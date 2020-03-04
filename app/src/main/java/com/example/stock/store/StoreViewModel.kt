package com.example.stock.store

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.stock.api.JSONApi
import com.example.stock.utils.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class StoreViewModel(private val api: JSONApi) : BaseViewModel(){

    var devText: ObservableField<String> = ObservableField("devText")

    init {
        loadData()
    }

    private fun loadData(){

        addDisposable(
            api.getStore()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
//                    showProgress()
                }
                .doOnTerminate {
//                    hideProgress()
                }
                .subscribe({ data ->
                    devText.set(data.result[0].address)
                }, {
                        error -> Log.e("Error", error.message)
                })
        )
    }
}