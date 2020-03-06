package com.example.stock.storeLocation

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProviders
import com.example.stock.R
import com.example.stock.databinding.StoreLocationActivityBinding
import com.example.stock.utils.*
import com.example.stock.utils.isPermissionGranted
import com.example.stock.utils.requestPermission
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.location.*

@SuppressLint("Registered")
class StoreLocationActivity : BaseActivity<StoreLocationActivityBinding>() {

    override val layoutResourceId = R.layout.store_location_activity

    lateinit var viewModel: StoreLocationViewModel

    private var fusedLocationClient: FusedLocationProviderClient? = null
    private var isNetworkLocation: Boolean = false
    private var isGPSLocation:Boolean = false

    private lateinit var locationRequest: LocationRequest
    private lateinit var currentLocation: Location

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(StoreLocationViewModel::class.java)
        viewDataBinding.viewModel = viewModel
        viewDataBinding.lifecycleOwner = this

        val mListener = getSystemService(Context.LOCATION_SERVICE) as? LocationManager
        if( mListener != null){
            /*
             * 현재 단말기의 GPS 여부를 확인한다
             */
            isGPSLocation = mListener.isProviderEnabled(LocationManager.GPS_PROVIDER)
            isNetworkLocation = mListener.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
            Log.d("gps,network","$isGPSLocation , $isNetworkLocation")
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            checkMyPermissionLocation()
        } else {
            initLocation()
        }
    }

    private fun checkMyPermissionLocation(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermission(this)
        }else{
            initLocation()
        }
    }

    private val locationCallback = object : LocationCallback(){
        override fun onLocationResult(result: LocationResult?) {
            super.onLocationResult(result)

            currentLocation = result!!.locations[0]
            viewModel.devText.set("${currentLocation.latitude}, ${currentLocation.longitude}")
            Log.d("location", "${currentLocation.latitude}, ${currentLocation.longitude}")
        }
    }

    @SuppressLint("MissingPermission")
    private fun initLocation(){
        if (!isGPSLocation){

            LocationSettingDialog.newInstance().show(supportFragmentManager,"위치설정")
        }

        locationRequest = LocationRequest()
        locationRequest.interval = 10000
        locationRequest.fastestInterval = 10000
        locationRequest.numUpdates = 1
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        val builder = LocationSettingsRequest.Builder()
        builder.addLocationRequest(locationRequest)

        val settingsClient = LocationServices.getSettingsClient(this)
        val locationSettingsRequest = builder.build()
        val locationResponse = settingsClient.checkLocationSettings(locationSettingsRequest)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        with(locationResponse){
            addOnSuccessListener{
                Log.d("Response", "Success!!")
                fusedLocationClient?.requestLocationUpdates(
                    locationRequest, locationCallback, Looper.myLooper())
            }
            addOnFailureListener{
                when ((it as ApiException).statusCode) {
                    LocationSettingsStatusCodes.RESOLUTION_REQUIRED -> Log.e("onFailure", "위치환경체크")
                    LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE -> {
                        Log.e("onFailure", "위치설정체크요망")
                    }
                }
            }
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode != REQUEST_CODE){
            return
        }

        if (isPermissionGranted(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), grantResults)) {
            initLocation()
        } else {
            showLongToast("해당 기능은 위치 정보 사용이 필요합니다.")
            finish()

            return
        }
    }

    override fun onRestart() {
        super.onRestart()

        if (!isGPSLocation){
            finish()
        }
    }

    override fun onStop() {
        super.onStop()

        fusedLocationClient?.removeLocationUpdates(locationCallback)
    }
}