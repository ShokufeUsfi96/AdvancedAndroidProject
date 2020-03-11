package com.usefi.advancedandroidproject.MVVM_dagger2

import io.reactivex.Observable
import java.util.*
import javax.inject.Inject

class Network @Inject constructor() {

    fun getName() = Observable.just("Shokufe")
}