package com.example.stock.utils

import android.text.TextUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.stock.adapter.StoreAdapter
import com.example.stock.adapter.StoreImageAdapter
import com.example.stock.bean.DetailImageBean
import com.example.stock.bean.ResultBean

@BindingAdapter("url")
fun setImageUrl(view: ImageView, url: String?){

    if(!TextUtils.isEmpty(url)){
        Glide.with(view.context)
            .load(url)
            .into(view)
    }
}

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

@BindingAdapter("bind_imgAdapter")
fun setBindImgAdapter(view: RecyclerView, adapter: StoreImageAdapter?){
    adapter?.let {

        view.adapter = it

    }
}

@BindingAdapter("bind_imgs")
fun setBindImgs(view: RecyclerView, items: List<DetailImageBean>?){
    items?.let {

        val adapter = view.adapter as StoreImageAdapter
        adapter.setItems(items)
        adapter.notifyDataSetChanged()

    }
}

@BindingAdapter("imgs_count")
fun setImgsCount(view: RecyclerView, count: Int){

    val adapter = view.adapter as StoreImageAdapter
    adapter.setImgCount(count)
    adapter.notifyDataSetChanged()

}