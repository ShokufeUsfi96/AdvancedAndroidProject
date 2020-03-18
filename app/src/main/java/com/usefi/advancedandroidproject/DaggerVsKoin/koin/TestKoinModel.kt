package com.usefi.advancedandroidproject.DaggerVsKoin.koin

import com.usefi.advancedandroidproject.pojo.AladhanResponseModel
import com.usefi.advancedandroidproject.retrofit.RetrofitInterface
import io.reactivex.Observable
import retrofit2.Retrofit

class TestKoinModel (val retrofit : Retrofit) {

    fun sendKoinCityCountry() : RetrofitInterface {
        return retrofit.create(RetrofitInterface::class.java)
    }
    fun getKoinData(city: String, country: String) : Observable<AladhanResponseModel> {
        return sendKoinCityCountry().getTiming(city, country, 8)
    }
}