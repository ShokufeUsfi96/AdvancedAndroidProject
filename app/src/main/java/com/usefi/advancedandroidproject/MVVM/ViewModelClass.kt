package com.usefi.advancedandroidproject.MVVM

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.usefi.advancedandroidproject.pojo.AladhanResponseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ViewModelClass : ViewModel() {
    private val model = ModelClass()
    private val disposable = CompositeDisposable()

    private val currentTimeResponse = MutableLiveData<Int>()
    private val timingsResponse = MutableLiveData<AladhanResponseModel>()

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
            model.getTimesObservable(city, country)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    timingsResponse.value = it
                    Log.d("TAG", "subscribe successfull!!")
                    //timingsResponse.value = it.data.timings.Dhuhr
                },{
                    Log.d("TAG", it.message.toString())
                })

        )
    }

    fun getImageLiveData() : LiveData <Int> = currentTimeResponse
    fun getTimesLiveData() : LiveData <AladhanResponseModel> = timingsResponse


    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }


}