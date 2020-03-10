package com.example.stock.di

import com.example.stock.api.JSONApi
import com.example.stock.constant.TEST_URL
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module{

    // Api
    single {

        Retrofit.Builder()
            .baseUrl(TEST_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(JSONApi::class.java)

    }

    // OkHttpClient
    single {

        // 네트뭐크 통신에 사용할 클라이언트 객체를 생성합니다.
        // 이 클라이언트를 통해 오고 가는 네트워크 요청/응답을 로그로 표시하도록 합니다.
        OkHttpClient.Builder().addInterceptor(get() as HttpLoggingInterceptor).build()

    }

    // HttpLoggingInterceptor
    single {

        // 네트워크 요청/응답을 로그에 표시하는 Interceptor 객체를 생성합니다.
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    }
}