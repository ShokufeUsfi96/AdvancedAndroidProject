package com.usefi.advancedandroidproject.MVVM

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.usefi.advancedandroidproject.R
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_prayer_times.*
import kotlinx.android.synthetic.main.activity_view.*
import kotlinx.android.synthetic.main.activity_view.edtCity
import kotlinx.android.synthetic.main.activity_view.edtCountry

class ViewActivity : AppCompatActivity() {

    val viewModel = ViewModelClass()
    val disposable= CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        btnTimes.setOnClickListener(){
            viewModel.onTimesButtonClicked(getCityCountry().first, getCityCountry().second)
        }


    }

    fun getCityCountry() : Pair<String , String >{
        val city = edtCity.text.toString()
        val country = edtCountry.text.toString()
        return  city to country
    }

    override fun onDestroy() {
        super.onDestroy()

        disposable.dispose()
    }
}
