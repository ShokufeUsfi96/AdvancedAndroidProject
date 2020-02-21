package com.usefi.advancedandroidproject.MVVM

import com.usefi.advancedandroidproject.pojo.AladhanResponseModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface RetrofitInterface {

    @GET("timingsByCity")
    fun getTimings(
        @Query("city")city : String,
        @Query("country")country : String,
        @Query("method")method : Int
    ): Observable<AladhanResponseModel>
}