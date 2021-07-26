package com.example.weather.api

import com.example.weather.weather.Weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
//    @GET("weather?q=cityName&appid=df30754bb998d15c44a7a318f02d7a20")
    @GET("weather?")
    suspend fun getWeather(
        @Query("q") cityName:String,
        @Query("appid") apiKey:String
    ):Response<Weather>
}