package com.example.stock.imageDetail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.stock.R
import com.example.stock.databinding.ImageActivityBinding
import com.example.stock.utils.BaseActivity

@SuppressLint("Registered")
class DetailImageActivity() : BaseActivity<ImageActivityBinding>() {

    override val layoutResourceId = R.layout.image_activity

    companion object{

        const val KEY_URL = "key_url"

    }

    private lateinit var viewModel: DetailImageViewModel
    private var url: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(DetailImageViewModel::class.java)
        viewDataBinding.viewModel = viewModel
        viewDataBinding.lifecycleOwner = this

        getUrlFromIntent()
    }

    private fun getUrlFromIntent(){

        url = intent.getSerializableExtra(KEY_URL) as String
        viewModel.setUrl(url)
    }
}