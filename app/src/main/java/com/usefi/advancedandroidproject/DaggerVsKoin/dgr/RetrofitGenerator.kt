package com.usefi.advancedandroidproject.DaggerVsKoin.dgr

import com.usefi.advancedandroidproject.retrofit.RetrofitInterface
import dagger.Component
import dagger.Provides
import org.koin.dsl.module
import retrofit2.Retrofit

@Component(modules = [RetrofitModule::class])
interface RetrofitGenerator {

    fun ProvideRetrofit(): Retrofit
}