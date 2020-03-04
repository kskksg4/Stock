package com.example.stock.api

import com.example.stock.bean.StoreBean
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface JSONApi{

    @GET("store_dev.php")
    fun getStore(): Observable<StoreBean>
}