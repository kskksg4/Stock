package com.example.stock

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.viewpager.widget.ViewPager
import com.example.stock.api.JSONApi
import com.example.stock.utils.BaseActivity
import com.example.stock.utils.REQUEST_CODE
import com.example.stock.utils.isPermissionGranted
import com.example.stock.utils.requestPermission
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val adapter by lazy { MainAdapter(supportFragmentManager) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkMyPermissionLocation()
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                mainIndicator.selectDot(position)
            }

        })

        mainIndicator.createDotPanel(2, R.drawable.outline_lens_white_18dp,
            R.drawable.baseline_lens_white_18dp, 0)
    }

    private fun checkMyPermissionLocation(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermission(this)
        }
    }
}
