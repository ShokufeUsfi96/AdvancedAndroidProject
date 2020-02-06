package com.usefi.advancedandroidproject

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),TestRecyclerClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = arrayListOf<String>("  Profile","  Products","  Share","  About Us")

        var clickListener: (String)->Unit={
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        }

        val adapter = TestKotlinRecyclerAdapter(list, clickListener)
        recycler.adapter = adapter


    }

    override fun onclick(name: String) {
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
    }
}
