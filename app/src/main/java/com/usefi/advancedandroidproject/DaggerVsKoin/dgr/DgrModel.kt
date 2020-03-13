package com.usefi.advancedandroidproject.DaggerVsKoin.dgr

import com.usefi.advancedandroidproject.pojo.AladhanResponseModel
import com.usefi.advancedandroidproject.retrofit.RetrofitInterface
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject

class DgrModel() {

     val retro = DaggerRetrofitGenerator.create().ProvideRetrofit()

    fun getData(city: String, country: String) : Observable<AladhanResponseModel>{
      return retro.getTiming(city, country, 8)
    }

}