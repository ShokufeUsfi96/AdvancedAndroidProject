package com.usefi.advancedandroidproject.DaggerVsKoin.dgr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.usefi.advancedandroidproject.DaggerVsKoin.koin.TestKoinActivity
import com.usefi.advancedandroidproject.R
import kotlinx.android.synthetic.main.activity_dgr.*
import kotlinx.android.synthetic.main.activity_test_koin.*
import kotlinx.android.synthetic.main.activity_view.*

class DgrActivity : AppCompatActivity() {

    lateinit var viewModel : DgrViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dgr)

        val factory = DaggerFactoryComponent.create().ProvideVMFactory()
        viewModel = ViewModelProvider(this,factory).get(DgrViewModel::class.java)
        btnDagger.setOnClickListener{
            viewModel.getTimesClicked(getCityCountry().first, getCityCountry().second)
        }
        goToKoin.setOnClickListener {
            startActivity(Intent(this, TestKoinActivity::class.java))
        }

        viewModel.getTimeLiveData().observe(this, Observer{
            txtDagger.text = it.data.timings.Dhuhr
        })

    }

    fun getCityCountry() : Pair<String , String >{
        val city = edtCity2.text.toString()
        val country = edtCountry2.text.toString()
        return  city to country
    }
}
