package com.usefi.advancedandroidproject.MVVM_dagger2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.usefi.advancedandroidproject.R
import kotlinx.android.synthetic.main.activity_test_dagger_view.*

class TestDaggerView : AppCompatActivity() {

    private lateinit var viewModel : TestDaggerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_dagger_view)

        val factory = DaggerVMFactoryComponent.create().provideVMFactory()
        viewModel = ViewModelProvider(this, factory).get(TestDaggerViewModel::class.java)

        showName.setOnClickListener{
            viewModel.getName()
        }

        viewModel.getLivedata().observe(this, Observer{
            name.text = it
        })
    }
}
