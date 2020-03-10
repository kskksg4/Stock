package com.example.stock.storeDetail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.stock.R
import com.example.stock.adapter.StoreImageAdapter
import com.example.stock.api.JSONApi
import com.example.stock.bean.DetailImageBean
import com.example.stock.databinding.DetailActivityBinding
import com.example.stock.utils.BaseActivity
import org.koin.android.ext.android.inject

@SuppressLint("Registered")
class DetailActivity : BaseActivity<DetailActivityBinding>(), StoreImageAdapter.OnItemClickListener {

    companion object{

        const val KEY_ID = "key_id"

    }

    override val layoutResourceId = R.layout.detail_activity

    private val api: JSONApi by inject()

    private val adapter = StoreImageAdapter().apply { setClickListener(this@DetailActivity) }

    private lateinit var viewModel: DetailViewModel
    private lateinit var viewModelFactory: DetailViewModelFactory
    private var storeId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModelFactory = DetailViewModelFactory(adapter, api)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(DetailViewModel::class.java)
        viewDataBinding.viewModel = viewModel
        viewDataBinding.lifecycleOwner = this

        getIdFromIntent()
    }

    private fun getIdFromIntent(){

        storeId = intent.getSerializableExtra(KEY_ID) as Int
        viewModel.loadData(storeId)
    }

    override fun onClick(bean: DetailImageBean?) {
        if (bean != null) {
            showToast(bean.imgUrl1)
        }
    }
}