package com.usefi.advancedandroidproject.MVVM

import com.usefi.advancedandroidproject.R
import com.usefi.advancedandroidproject.pojo.AladhanResponseModel
import com.usefi.advancedandroidproject.retrofit.RetrofitInterface
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ModelClass {

    fun checkCurrentTime(currentTime : Int) = Observable
        .just(when(currentTime){
            20,21,22,23,0,1,2,3 -> {R.drawable.night}
            in 4..8 -> R.drawable.sunrise
            in 9..15 -> R.drawable.noon
            else -> R.drawable.sunset
        })

    fun sendCityCountry(city: String, country: String) : Observable<AladhanResponseModel>{

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.aladhan.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        val timingInterface : RetrofitInterface = retrofit.create(RetrofitInterface::class.java)

        return timingInterface.getTiming(city , country , 8)

    }
}