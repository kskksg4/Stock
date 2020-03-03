package com.example.stock.bean

import com.google.gson.annotations.SerializedName

data class StoreBean(
    @SerializedName("result")
    val result: List<ResultBean>,

    @SerializedName("status")
    val status: Int,

    @SerializedName("total")
    val total: Int
)