package com.example.stock.bean

import com.google.gson.annotations.SerializedName

data class ResultBean(
    @SerializedName("address")
    val address: String,

    @SerializedName("id")
    val id : Int,

    @SerializedName("lat")
    val lat: Double,

    @SerializedName("lng")
    val lng: Double,

    @SerializedName("name")
    val name: String
)