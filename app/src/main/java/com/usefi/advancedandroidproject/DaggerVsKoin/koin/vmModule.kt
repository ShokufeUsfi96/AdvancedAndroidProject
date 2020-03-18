package com.usefi.advancedandroidproject.DaggerVsKoin.koin

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val vmModule = module {
    viewModel { TestKoinViewModel(get()) }

}