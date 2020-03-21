package com.example.stock.bean

import com.google.gson.annotations.SerializedName

data class ResultBean(
    @SerializedName("isstock")
    val isstock: Int,

    @SerializedName("id")
    val id : Int,

    @SerializedName("lat")
    val lat: Double,

    @SerializedName("lng")
    val lng: Double,

    @SerializedName("name")
    val name: String,

    @SerializedName("thumComment")
    val thumComment: String,

    @SerializedName("thumImg")
    val thumImg: String
)