package com.usefi.advancedandroidproject.MVVM

import io.reactivex.disposables.CompositeDisposable

class ViewModelClass {
    val model = ModelClass()

    fun onTimesButtonClicked(city : String, country : String){

        model.SendCityCountry(city,country)
    }


}