package com.usefi.advancedandroidproject.MVP

import com.usefi.advancedandroidproject.R
import com.usefi.advancedandroidproject.pojo.AladhanResponseModel
import com.usefi.advancedandroidproject.retrofit.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PrayerTimesModel(val presenter: PrayerTimesContract.Presenter) {

    fun SendCityCountry(city : String, country : String){

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.aladhan.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val timingInterface : RetrofitInterface = retrofit.create(RetrofitInterface::class.java)



        timingInterface.getTimings(city , country , 8)
            .enqueue(object : Callback <AladhanResponseModel>{
                override fun onFailure(call: Call<AladhanResponseModel>, t: Throwable) {

                    presenter.onRecieveError(t.message)
                }

                override fun onResponse(call: Call<AladhanResponseModel>, response: Response<AladhanResponseModel>) {
                    var fajr =  response.body()?.data?.timings?.Fajr.toString()
                    var sunrise =  response.body()?.data?.timings?.Sunrise.toString()
                    var dhuhr =  response.body()?.data?.timings?.Dhuhr.toString()
                    var sunset =  response.body()?.data?.timings?.Sunset.toString()
                    var asr =  response.body()?.data?.timings?.Asr.toString()
                    var maghrib =  response.body()?.data?.timings?.Maghrib.toString()
                    var isha =  response.body()?.data?.timings?.Isha.toString()
                    var imsak =  response.body()?.data?.timings?.Imsak.toString()
                    var midnight =  response.body()?.data?.timings?.Midnight.toString()

                    presenter.getTimes(fajr, sunrise, dhuhr, sunset, asr, maghrib, isha, imsak, midnight)
                }
            })
    }

    fun checkCurrentTime(currentTime : Int){

        when(currentTime){
            20,21,22,23,0,1,2,3 -> {  presenter.setImageAddress(R.drawable.night) }
            in 4..8 -> { presenter.setImageAddress(R.drawable.sunrise) }
            in 9..15 -> { presenter.setImageAddress(R.drawable.noon) }
            in 16..19 -> { presenter.setImageAddress(R.drawable.sunset) }
        }

    }

}