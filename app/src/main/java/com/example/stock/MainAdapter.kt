package com.example.stock

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.stock.mainView.MainLocationFragment
import com.example.stock.mainView.MainStoreFragment

class MainAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm){
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> MainStoreFragment()
            else -> MainLocationFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun destroyItem(container: View, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
    }
}