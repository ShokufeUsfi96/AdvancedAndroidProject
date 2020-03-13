package com.usefi.advancedandroidproject.DaggerVsKoin.koin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.usefi.advancedandroidproject.DaggerVsKoin.dgr.DgrViewModel
import com.usefi.advancedandroidproject.R
import kotlinx.android.synthetic.main.activity_dgr.*
import kotlinx.android.synthetic.main.activity_test_koin.*
import org.koin.android.viewmodel.compat.ScopeCompat.viewModel
import org.koin.android.viewmodel.ext.android.viewModel

class TestKoinActivity : AppCompatActivity() {

    private lateinit var vm: TestKoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_koin)

        vm = ViewModelProvider(this).get(TestKoinViewModel::class.java)

        btnKoin.setOnClickListener{
            vm.getKoinTimes(getCityCountry().first, getCityCountry().second)
        }

        vm.getTimeLiveData().observe(this, Observer{
            txtKoin.text = it.data.timings.Maghrib.toString()
        })

    }

    fun getCityCountry() : Pair<String , String >{
        val city = edtCity3.text.toString()
        val country = edtCountry3.text.toString()
        return  city to country
    }
}