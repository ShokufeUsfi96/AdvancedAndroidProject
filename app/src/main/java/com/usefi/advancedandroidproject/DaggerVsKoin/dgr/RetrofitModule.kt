package com.usefi.advancedandroidproject.DaggerVsKoin.dgr

import com.usefi.advancedandroidproject.retrofit.RetrofitInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RetrofitModule{
    @Provides
    fun RetrofitProvider() : RetrofitInterface{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.aladhan.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        return retrofit.create(RetrofitInterface::class.java)
    }

}