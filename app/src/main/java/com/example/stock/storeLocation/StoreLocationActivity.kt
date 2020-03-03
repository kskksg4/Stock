package com.example.stock.storeLocation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.stock.R
import com.example.stock.databinding.StoreLocationActivityBinding
import com.example.stock.utils.BaseActivity

@SuppressLint("Registered")
class StoreLocationActivity : BaseActivity<StoreLocationActivityBinding>() {

    override val layoutResourceId = R.layout.store_location_activity

    lateinit var viewModel: StoreLocationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(StoreLocationViewModel::class.java)
        viewDataBinding.viewModel = viewModel
        viewDataBinding.lifecycleOwner = this
    }
}