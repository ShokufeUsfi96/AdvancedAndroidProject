package com.usefi.advancedandroidproject

import android.view.View

fun View.show(){
    visibility = View.VISIBLE
}
fun View.hide(){
    visibility = View.GONE
}



fun List<Double>.isStudentPassed() : Boolean{
    var sum = 0.00
    for(i in this){
        sum += i
    }
    return (sum/this.size) > 12.00
}