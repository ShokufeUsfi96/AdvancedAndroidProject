package com.usefi.advancedandroidproject.DaggerVsKoin.dgr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.usefi.advancedandroidproject.R
import kotlinx.android.synthetic.main.activity_dgr.*
import kotlinx.android.synthetic.main.activity_view.*

class DgrActivity : AppCompatActivity() {

    lateinit var viewModel : DgrViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dgr)

        val model =DgrModel()
        val factory = VMFactoryProvider(model)
        viewModel = ViewModelProvider(this,factory).get(DgrViewModel::class.java)
        btnDagger.setOnClickListener{
            viewModel.getTimesClicked(getCityCountry().first, getCityCountry().second)
        }

        viewModel.getTimeLiveData().observe(this, Observer{
            txtDagger.text = it.data.timings.Dhuhr.toString()
        })

    }

    fun getCityCountry() : Pair<String , String >{
        val city = edtCity2.text.toString()
        val country = edtCountry2.text.toString()
        return  city to country
    }
}
