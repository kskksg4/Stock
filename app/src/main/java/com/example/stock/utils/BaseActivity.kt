package com.example.stock.utils

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseActivity<T: ViewDataBinding> : AppCompatActivity() {

    lateinit var viewDataBinding: T

    abstract val layoutResourceId: Int

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewDataBinding = DataBindingUtil.setContentView(this, layoutResourceId)
    }

    fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun showLongToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    fun addDisposable(disposable: Disposable){
        compositeDisposable.add(disposable)
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        Log.d("clear", "onCleared")

        super.onDestroy()
    }
}