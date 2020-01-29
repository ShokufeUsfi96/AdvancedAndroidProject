package com.usefi.advancedandroidproject

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.drawerlayout.widget.DrawerLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val drawerLayout = drawer
        val list = arrayListOf<String>("  Profile","  Products","  Share","  About Us")

        val adapter = TestKotlinRecyclerAdapter(list)
        recycler.adapter = adapter


    }
}
