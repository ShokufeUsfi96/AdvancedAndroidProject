package com.usefi.advancedandroidproject.DaggerVsKoin.dgr

import com.usefi.advancedandroidproject.retrofit.RetrofitInterface
import dagger.Component
import dagger.Provides
import org.koin.dsl.module

@Component(modules = [RetrofitModule::class])
interface RetrofitGenerator {

    fun ProvideRetrofit(): RetrofitInterface
}