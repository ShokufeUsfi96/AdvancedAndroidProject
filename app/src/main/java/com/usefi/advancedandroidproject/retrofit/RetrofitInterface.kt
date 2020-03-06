package com.usefi.advancedandroidproject.retrofit

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
    ): Call<AladhanResponseModel>

    @GET("timingsByCity")
    fun getTiming(
        @Query("city")city : String,
        @Query("country")country : String,
        @Query("method")method : Int
    ): Observable<AladhanResponseModel>
}