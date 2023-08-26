package com.example.retrofitgetapiforrxjava.Retrofit

import com.example.retrofitgetapiforrxjava.models.Movie
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServise {

    //oddiy holat
//    @GET("marvel")
//    fun getMovie():Call<List<Movie>>

    //RxJava
    @GET("marvel")
    fun getApi(): Single<ArrayList<Movie>>
}