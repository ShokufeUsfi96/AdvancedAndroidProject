package com.usefi.advancedandroidproject.DaggerVsKoin.dgr

import dagger.Component

@Component
interface FactoryComponent {

    fun ProvideVMFactory() : VMFactoryProvider
}