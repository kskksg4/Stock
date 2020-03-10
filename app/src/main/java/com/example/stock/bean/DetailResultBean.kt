package com.example.stock.bean

import com.google.gson.annotations.SerializedName

data class DetailResultBean(
    @SerializedName("address")
    val address: String,

    @SerializedName("id")
    val id: Int,

    @SerializedName("images")
    val images: List<DetailImageBean>,

    @SerializedName("menuPr")
    val menuPr: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("tel")
    val tel: Int
)