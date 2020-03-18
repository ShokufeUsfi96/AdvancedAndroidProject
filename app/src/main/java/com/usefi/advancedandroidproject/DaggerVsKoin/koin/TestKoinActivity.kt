package com.usefi.advancedandroidproject.DaggerVsKoin.koin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.usefi.advancedandroidproject.DaggerVsKoin.dgr.DgrActivity
import com.usefi.advancedandroidproject.R
import kotlinx.android.synthetic.main.activity_test_koin.*
import org.koin.android.viewmodel.ext.android.viewModel

class TestKoinActivity : AppCompatActivity() {

   private val vmodel : TestKoinViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_koin)

        btnKoin.setOnClickListener{
            vmodel.getKoinTimes(getCityCountry().first, getCityCountry().second)
        }
        goToDagger.setOnClickListener {
            startActivity(Intent(this, DgrActivity::class.java))
        }

        vmodel.getKoinTimeLiveData().observe(this, Observer{
            txtKoin.text = it.data.timings.Maghrib
        })

    }

    fun getCityCountry() : Pair<String , String >{
        val city = edtCity3.text.toString()
        val country = edtCountry3.text.toString()
        return  city to country
    }
}