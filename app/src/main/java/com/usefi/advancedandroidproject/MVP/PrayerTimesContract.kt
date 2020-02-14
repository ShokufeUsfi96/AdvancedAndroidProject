package com.usefi.advancedandroidproject.MVP

interface PrayerTimesContract {
    interface Presenter :
        ParentPresenter {

        fun onTimesButtonClicked()
        fun onRecieveError(t: String?)
        fun getTimes(fajr : String, sunrise : String, dhuhr : String, sunset : String, asr : String,
                     maghrib : String, isha : String, imsak : String, midnight : String)
        fun getCurrentTime(currentTime : Int)
        fun setImageAddress(Image : Int)
    }

    interface View{

        fun getCityCountry(): Pair<String, String>
        fun showError(t : String?)
        fun setTimes(fajr : String, sunrise : String, dhuhr : String, sunset : String, asr : String,
                     maghrib : String, isha : String, imsak : String, midnight : String)

        fun loadImage(Image : Int)

    }

    interface ParentPresenter {

    }
}