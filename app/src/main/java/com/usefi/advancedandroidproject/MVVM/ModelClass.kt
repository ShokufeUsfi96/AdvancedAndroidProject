package com.usefi.advancedandroidproject.MVVM

import com.usefi.advancedandroidproject.pojo.AladhanResponseModel
import com.usefi.advancedandroidproject.retrofit.RetrofitInterface
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class ModelClass {

    fun retrofitObservable(country: String, city: String, method : Int) : Observable<AladhanResponseModel> {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.aladhan.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        val timingInterface : RetrofitInterface = retrofit.create(RetrofitInterface::class.java)

        return timingInterface.getTimings(city , country , 8)



    }
}