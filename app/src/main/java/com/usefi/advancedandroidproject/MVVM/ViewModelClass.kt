package com.usefi.advancedandroidproject.MVVM

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class ViewModelClass : ViewModel() {
    private val model = ModelClass()
    private val disposable = CompositeDisposable()

    private val currentTimeResponse = MutableLiveData<Int>()
    private val timingsResponse = MutableLiveData<String>()

    fun getCurrentTime(currentTime : Int){
        disposable.add(
            model.checkCurrentTime(currentTime)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        currentTimeResponse.value = it
                    },{
                        Log.d("TAG", it.message.toString())
                    })
        )
    }

    fun onTimesButtonClicked(city : String, country : String){
        disposable.add(
            model.sendCityCountry(city,country)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    timingsResponse.value = it.data.timings.Fajr
                    Log.d("TAG", "subscribe successfull!!")
                    //timingsResponse.value = it.data.timings.Dhuhr
                },{
                    Log.d("TAG", it.message.toString())
                })

        )
    }

    fun getImageLiveData() : LiveData <Int> = currentTimeResponse
    fun getTimesLiveData() : LiveData <String> = timingsResponse


    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }


}