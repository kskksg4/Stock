package com.example.stock.bean

import com.google.gson.annotations.SerializedName

data class DetailBean(
    @SerializedName("result")
    val result: List<DetailResultBean>,

    @SerializedName("status")
    val status: Int,

    @SerializedName("total")
    val total: Int
)
