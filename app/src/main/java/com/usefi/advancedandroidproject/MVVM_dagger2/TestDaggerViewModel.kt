package com.usefi.advancedandroidproject.MVVM_dagger2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class TestDaggerViewModel(private val network: Network): ViewModel() {

    private val livedata = MutableLiveData<String>()
    val disposable = CompositeDisposable()

    fun getLivedata() : LiveData<String> = livedata

    fun getName() {
        disposable.add(
            network.getName()
                .subscribe({
                    livedata.value = it
                },{
                    Log.d("TAG", it.message.toString())
                })
        )

    }

    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }
}