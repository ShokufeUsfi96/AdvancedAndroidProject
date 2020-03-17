package com.usefi.advancedandroidproject.DaggerVsKoin.dgr

import dagger.Component
import javax.inject.Inject

@Component
interface FactoryComponent {

    fun ProvideVMFactory() : VMFactoryProvider
}