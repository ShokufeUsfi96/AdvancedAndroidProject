package com.usefi.advancedandroidproject.DaggerVsKoin.koin

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.usefi.advancedandroidproject.pojo.AladhanResponseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class TestKoinViewModel(val model: TestKoinModel) : ViewModel() {

    private  val TimeKoinLiveData = MutableLiveData<AladhanResponseModel>()
    val disposable = CompositeDisposable()

    fun getKoinTimes(city: String, country: String) {
        disposable.add(
            model.getKoinData(city, country)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    TimeKoinLiveData.value = it
                    Log.d("TAG", "subscribe successfull!!")
                },{
                    Log.d("TAG", it.message.toString())
                })
        )

    }



    fun getKoinTimeLiveData() : LiveData<AladhanResponseModel> = TimeKoinLiveData
    override fun onCleared(){
        disposable.clear()
        super.onCleared()
    }
}