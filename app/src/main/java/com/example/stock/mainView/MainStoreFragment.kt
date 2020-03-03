package com.example.stock.mainView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.stock.databinding.MainStoreFragmentBinding

class MainStoreFragment : Fragment() {

    lateinit var viewModel: MainStoreViewModel
    lateinit var bind: MainStoreFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bind = MainStoreFragmentBinding.inflate(inflater, container, false)
        bind.lifecycleOwner = this
        viewModel = ViewModelProviders.of(requireActivity()).get(MainStoreViewModel::class.java)
        bind.viewModel = viewModel

        return bind.root
    }
}