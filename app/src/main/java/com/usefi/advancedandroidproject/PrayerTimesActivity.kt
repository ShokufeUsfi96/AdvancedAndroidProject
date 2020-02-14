package com.usefi.advancedandroidproject

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.usefi.advancedandroidproject.MVP.PrayerTimesContract
import com.usefi.advancedandroidproject.MVP.PrayerTimesPresenter
import kotlinx.android.synthetic.main.activity_prayer_times.*
import java.util.*


class PrayerTimesActivity : AppCompatActivity(),
    PrayerTimesContract.View {

    private val presenter : PrayerTimesContract.Presenter =
        PrayerTimesPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prayer_times)

        val currentTime : Int = Calendar.getInstance()[Calendar.HOUR_OF_DAY]
        presenter.getCurrentTime(currentTime)

        btnTimes.setOnClickListener(){
            presenter.onTimesButtonClicked()
        }
    }

    override fun getCityCountry() : Pair<String , String >{
        val city = edtCity.text.toString()
        val country = edtCountry.text.toString()
        return  city to country
    }

    override fun showError(t : String?){
        Toast.makeText(this, t.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun setTimes(fajr : String, sunrise : String, dhuhr : String, sunset : String,
                          asr : String, maghrib : String, isha : String, imsak : String, midnight : String) {
        txtFajr.text = fajr
        txtSunrise.text = sunrise
        txtDhuhr.text = dhuhr
        txtSunset.text = sunset
        txtAsr.text = asr
        txtMaghrib.text = maghrib
        txtIsha.text = isha
        txtImsak.text = imsak
        txtMidnight.text = midnight
    }

    override fun loadImage(Image : Int){
        img.setImageResource(Image)
    }


}
