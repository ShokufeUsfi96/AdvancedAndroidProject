package com.usefi.advancedandroidproject.MVVM

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.usefi.advancedandroidproject.R
import kotlinx.android.synthetic.main.activity_view.*
import java.util.*

class ViewActivity : AppCompatActivity() {

    lateinit var viewModel : ViewModelClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        viewModel = ViewModelProvider(this).get(ViewModelClass::class.java)

        val currentTime : Int = Calendar.getInstance()[Calendar.HOUR_OF_DAY]
        viewModel.getCurrentTime(currentTime)

        viewModel.getImageLiveData().observe(this, androidx.lifecycle.Observer {
            imgTime.setImageResource(it)
        })

        viewModel.getTimesLiveData().observe(this, androidx.lifecycle.Observer {
            txFajr.text = it.toString()
        })


        btnShow.setOnClickListener{
            viewModel.onTimesButtonClicked(getCityCountry().first, getCityCountry().second)
        }


    }

    fun getCityCountry() : Pair<String , String >{
        val city = edCity.text.toString()
        val country = edCountry.text.toString()
        return  city to country
    }

}
