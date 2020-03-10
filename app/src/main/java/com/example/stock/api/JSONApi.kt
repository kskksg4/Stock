package com.example.stock.api

import com.example.stock.bean.DetailBean
import com.example.stock.bean.StoreBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface JSONApi {

    @GET("store_dev.php")
    fun getStore(): Observable<StoreBean>

    @GET("location_dev.php")
    fun getLocationStore(
        @Query("lat") lat: Double?,
        @Query("lng") lng: Double?
    ): Observable<StoreBean>

    @GET("detail_dev.php")
    fun getDetailStore(
        @Query("id") id: Int
    ): Observable<DetailBean>
}