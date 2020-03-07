package com.example.stock.store

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.stock.R
import com.example.stock.adapter.StoreAdapter
import com.example.stock.api.JSONApi
import com.example.stock.bean.ResultBean
import com.example.stock.databinding.StoreActivityBinding
import com.example.stock.utils.BaseActivity
import org.koin.android.ext.android.inject

@SuppressLint("Registered")
class StoreActivity : BaseActivity<StoreActivityBinding>(), StoreAdapter.OnItemClickListener {

    override val layoutResourceId = R.layout.store_activity

    private val api: JSONApi by inject()

    private val adapter = StoreAdapter().apply { setClickListener(this@StoreActivity) }

    private lateinit var viewModel: StoreViewModel
    private lateinit var viewModelFactory: StoreViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModelFactory = StoreViewModelFactory(adapter, api)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(StoreViewModel::class.java)
        viewDataBinding.viewModel = viewModel
        viewDataBinding.lifecycleOwner = this
    }

    override fun onClick(bean: ResultBean?) {
        // intent 추가
        if (bean != null) {
            showToast("${bean.isstock}")
        }
    }
}