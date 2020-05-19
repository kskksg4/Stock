package com.example.stock.storeDetail

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.stock.R
import com.example.stock.adapter.StoreImageAdapter
import com.example.stock.api.JSONApi
import com.example.stock.bean.DetailImageBean
import com.example.stock.databinding.DetailActivityBinding
import com.example.stock.imageDetail.DetailImageActivity
import com.example.stock.rxevent.RxEvent
import com.example.stock.utils.BaseActivity
import com.example.stock.utils.RxBus
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.store_activity.*
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

        btn_back.setOnClickListener {
            finish()
        }

        addDisposable(RxBus.listen(RxEvent.EventSendNumber::class.java)
            .subscribe {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${it.telNumber}"))
                startActivity(intent)
        })
    }

    private fun getIdFromIntent(){

        storeId = intent.getSerializableExtra(KEY_ID) as Int
        viewModel.loadData(storeId)
    }

    override fun onClick(url: String?) {
//        showToast("$url")

        val intent = Intent(this, DetailImageActivity::class.java)

        intent.putExtra(DetailImageActivity.KEY_URL, url)
        startActivity(intent)
    }
}