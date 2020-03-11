package com.usefi.advancedandroidproject.MVVM_dagger2

import dagger.Component

@Component
interface VMFactoryComponent {

    fun provideVMFactory() : VMFactoryProvider
}