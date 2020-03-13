package com.usefi.advancedandroidproject.DaggerVsKoin.koin

import com.usefi.advancedandroidproject.pojo.AladhanResponseModel
import com.usefi.advancedandroidproject.retrofit.RetrofitInterface
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class TestKoinModel {

    fun sendCityCountry() : RetrofitInterface {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.aladhan.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        return retrofit.create(RetrofitInterface::class.java)

    }
    fun getData(city: String, country: String) : Observable<AladhanResponseModel> {
        return sendCityCountry().getTiming(city, country, 8)
    }
}