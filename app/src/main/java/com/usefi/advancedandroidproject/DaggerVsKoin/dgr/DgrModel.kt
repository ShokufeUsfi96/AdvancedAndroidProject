package com.usefi.advancedandroidproject.DaggerVsKoin.dgr

import com.usefi.advancedandroidproject.pojo.AladhanResponseModel
import com.usefi.advancedandroidproject.retrofit.RetrofitInterface
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Inject

class DgrModel @Inject constructor () {

    fun provideRetrofitData() : RetrofitInterface{
        return DaggerRetrofitGenerator.create().ProvideRetrofit()
            .create(RetrofitInterface::class.java)
    }


    fun getData(city: String, country: String) : Observable<AladhanResponseModel>{
      return provideRetrofitData().getTiming(city, country, 8)
    }
}