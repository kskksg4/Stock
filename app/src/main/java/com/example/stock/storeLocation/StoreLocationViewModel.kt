package com.example.stock.storeLocation

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.stock.adapter.StoreAdapter
import com.example.stock.api.JSONApi
import com.example.stock.bean.ResultBean
import com.example.stock.utils.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class StoreLocationViewModel(private val storeAdapter: StoreAdapter, private val api: JSONApi) : BaseViewModel() {

    private val stockList = mutableListOf<ResultBean>()

    private val _adapter = MutableLiveData<StoreAdapter>().apply { value = storeAdapter }
    private val _items = MutableLiveData<List<ResultBean>>()

    val adapter: LiveData<StoreAdapter> get() = _adapter
    val items: LiveData<List<ResultBean>> get() = _items

    var lat: ObservableField<Double> = ObservableField(0.0)
    var lng: ObservableField<Double> = ObservableField(0.0)

    fun loadData(){

        addDisposable(
            api.getLocationStore(lat.get(), lng.get())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
//                    showProgress()
                }
                .doOnTerminate {
//                    hideProgress()
                }
                .subscribe({ data ->
                    var i = 0

                    for (element in data.result){
                        if (element.isstock == 1){
                            stockList.add(i, element)
                            i++
                        }
                    }
                    _items.value = stockList
                }, {
                        error -> Log.e("Error", error.message)
                })
        )
    }
}