package com.example.stock.mainView

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.stock.databinding.MainLocationFragmentBinding

class MainLocationFragment : Fragment() {

    lateinit var viewModel: MainLocationViewModel
    lateinit var bind: MainLocationFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity!!.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        bind = MainLocationFragmentBinding.inflate(inflater, container, false)
        bind.lifecycleOwner = this
        viewModel = ViewModelProviders.of(requireActivity()).get(MainLocationViewModel::class.java)
        bind.viewModel = viewModel

        return bind.root
    }
}