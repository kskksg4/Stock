package com.example.stock.bean

import com.google.gson.annotations.SerializedName

data class DetailImageBean(
    @SerializedName("imgUrl1")
    val imgUrl1: String,

    @SerializedName("imgUrl2")
    val imgUrl2: String,

    @SerializedName("imgUrl3")
    val imgUrl3: String
)