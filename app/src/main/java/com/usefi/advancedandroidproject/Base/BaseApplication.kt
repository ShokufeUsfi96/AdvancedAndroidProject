package com.usefi.advancedandroidproject.Base

import android.app.Application
import com.usefi.advancedandroidproject.DaggerVsKoin.koin.RetrofitKoinModule
import com.usefi.advancedandroidproject.DaggerVsKoin.koin.vmModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@BaseApplication)
            modules(RetrofitKoinModule, vmModule)

        }
    }
}