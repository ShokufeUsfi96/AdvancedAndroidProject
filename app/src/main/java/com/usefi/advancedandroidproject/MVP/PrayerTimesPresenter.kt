package com.usefi.advancedandroidproject.MVP

import com.usefi.advancedandroidproject.MVP.PrayerTimesContract
import com.usefi.advancedandroidproject.MVP.PrayerTimesModel

class PrayerTimesPresenter(private val view: PrayerTimesContract.View) : PrayerTimesContract.Presenter{

    private val model =
        PrayerTimesModel(this)

    override fun onTimesButtonClicked(){
        val (city , country) = view.getCityCountry()

        model.SendCityCountry(city,country)
    }

    override fun onRecieveError(t : String?) {
        view.showError(t)
    }

    override fun getTimes(fajr : String, sunrise : String, dhuhr : String, sunset : String,
                          asr : String, maghrib : String, isha : String, imsak : String, midnight : String) {
        view.setTimes(fajr , sunrise , dhuhr , sunset , asr , maghrib , isha , imsak , midnight )
    }

    override fun getCurrentTime(currentTime : Int){
        model.checkCurrentTime(currentTime)
    }

    override fun setImageAddress(Image : Int){
        view.loadImage(Image)
    }

}