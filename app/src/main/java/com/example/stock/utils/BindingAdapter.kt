package com.example.stock.utils

import android.text.TextUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.stock.adapter.StoreAdapter
import com.example.stock.bean.ResultBean

//@BindingAdapter("url")
//fun setImageUrl(view: ImageView, profileUrl: String?) {
//
//    if(!TextUtils.isEmpty(profileUrl)) {
//        Glide.with(view.context)
//            .load(profileUrl)
//            .into(view)
//    }
//}

@BindingAdapter("bind_adapter")
fun setBindAdapter(view: RecyclerView, adapter: StoreAdapter?){
    adapter?.let {

        view.adapter = it

    }
}

@BindingAdapter("bind_items")
fun setBindItems(view: RecyclerView, items: List<ResultBean>?){
    items?.let {

        val adapter = view.adapter as StoreAdapter
        adapter.setItems(items)
        adapter.notifyDataSetChanged()

    }
}