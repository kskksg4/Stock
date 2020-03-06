package com.example.stock.store

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.stock.adapter.StoreAdapter
import com.example.stock.api.JSONApi
import com.example.stock.bean.ResultBean
import com.example.stock.utils.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class StoreViewModel(private val storeAdapter: StoreAdapter, private val api: JSONApi) : BaseViewModel(){

    var devText: ObservableField<String> = ObservableField("devText")

    private val _adapter = MutableLiveData<StoreAdapter>().apply { value = storeAdapter }
    private val _items = MutableLiveData<List<ResultBean>>()

    //mutableLiveData 를 immutable 하게 노출
    //ViewModel 내부에서는 Mutable 한 데이터를 외부에서는 Immutable 하게 사용하도록 제약을 주기 위함
    val adapter: LiveData<StoreAdapter> get() = _adapter
    val items: LiveData<List<ResultBean>> get() = _items

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
                    _items.value = data.result
                    Log.d("_items", _items.value!![0].address)
                }, {
                        error -> Log.e("Error", error.message)
                })
        )
    }
}