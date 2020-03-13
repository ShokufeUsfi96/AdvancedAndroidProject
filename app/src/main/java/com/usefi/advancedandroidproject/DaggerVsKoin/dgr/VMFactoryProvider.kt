package com.usefi.advancedandroidproject.DaggerVsKoin.dgr

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class VMFactoryProvider @Inject constructor(val model : DgrModel) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when{
            modelClass.isAssignableFrom(DgrViewModel::class.java) ->
                    return DgrViewModel(model) as T
            else -> throw IllegalArgumentException("ViewModel is not Provided!!")
        }
    }
}