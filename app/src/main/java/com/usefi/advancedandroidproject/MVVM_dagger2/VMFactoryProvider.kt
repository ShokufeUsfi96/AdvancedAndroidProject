package com.usefi.advancedandroidproject.MVVM_dagger2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class VMFactoryProvider @Inject constructor(val network: Network) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when{
            modelClass.isAssignableFrom(TestDaggerViewModel::class.java) ->
                    return TestDaggerViewModel(network) as T
            else -> throw IllegalArgumentException("ViewModel is not provided!!")
        }
    }
}