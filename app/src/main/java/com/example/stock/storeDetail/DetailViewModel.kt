package com.example.stock.storeDetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.stock.adapter.StoreImageAdapter
import com.example.stock.api.JSONApi
import com.example.stock.bean.DetailImageBean
import com.example.stock.bean.DetailResultBean
import com.example.stock.utils.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DetailViewModel(private val storeImageAdapter: StoreImageAdapter, private val api: JSONApi) :
    BaseViewModel() {

    private val _items = MutableLiveData<List<DetailResultBean>>()
    private val _adapter = MutableLiveData<StoreImageAdapter>().apply { value = storeImageAdapter }
    private val _img_arr = MutableLiveData<List<DetailImageBean>>()
    private val _img_cnt = MutableLiveData<Int>()

    val name = MutableLiveData<String>()
    val address = MutableLiveData<String>()
    val menuPr = MutableLiveData<String>()

    val adapter: LiveData<StoreImageAdapter> get() = _adapter
    val imgArrays: LiveData<List<DetailImageBean>> get() = _img_arr
    val count: LiveData<Int> get() = _img_cnt



    var list = ArrayList<String>()

    fun loadData(storeId: Int) {

        addDisposable(
            api.getDetailStore(storeId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {

                }
                .doOnTerminate {

                }
                .subscribe({ data ->
                    _items.value = data.result
                    _img_arr.value = _items.value!![0].images

                    list.add(0, _items.value!![0].images[0].imgUrl1)
                    list.add(1, _items.value!![0].images[0].imgUrl2)
                    list.add(2, _items.value!![0].images[0].imgUrl3)
                    list.add(3, _items.value!![0].images[0].imgUrl4)

                    _img_cnt.value = list.size

                    name.value = _items.value!![0].name
                    address.value = _items.value!![0].address
                    menuPr.value = _items.value!![0].menuPr
                }, {
                    error -> Log.e("Error", error.message)
                })
        )
    }
}