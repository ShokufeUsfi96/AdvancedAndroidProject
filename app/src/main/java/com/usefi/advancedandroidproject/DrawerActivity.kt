package com.usefi.advancedandroidproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class DrawerActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = arrayListOf<String>("  Prayer Times")

        var clickListener: (String)->Unit={
            val intent = Intent(this, PrayerTimesActivity::class.java)
            startActivity(intent)
        }

        val adapter = TestKotlinRecyclerAdapter(list, clickListener)
        recycler.adapter = adapter

    }



    //override fun onclick(name: String) {
       // }

}
