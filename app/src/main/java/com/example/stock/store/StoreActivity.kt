package com.example.stock.store

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.stock.R
import com.example.stock.databinding.StoreActivityBinding
import com.example.stock.utils.BaseActivity

@SuppressLint("Registered")
class StoreActivity : BaseActivity<StoreActivityBinding>() {

    override val layoutResourceId = R.layout.store_activity

    lateinit var viewModel: StoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(StoreViewModel::class.java)
        viewDataBinding.viewModel = viewModel
        viewDataBinding.lifecycleOwner = this
    }
}