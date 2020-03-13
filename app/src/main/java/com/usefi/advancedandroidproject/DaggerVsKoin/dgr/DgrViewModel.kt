package com.usefi.advancedandroidproject.DaggerVsKoin.dgr

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.usefi.advancedandroidproject.pojo.AladhanResponseModel
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DgrViewModel(private val model : DgrModel) : ViewModel(){

    private  val TimeLiveData = MutableLiveData<AladhanResponseModel>()
    val disposable = CompositeDisposable()

    fun getTimesClicked(city: String, country: String) {
        disposable.add(
            model.getData(city, country)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    TimeLiveData.value = it
                    Log.d("TAG", "subscribe successfull!!")
                },{
                    Log.d("TAG", it.message.toString())
                })
        )

    }



    fun getTimeLiveData() : LiveData<AladhanResponseModel> = TimeLiveData
    override fun onCleared(){
        disposable.clear()
        super.onCleared()
    }

}