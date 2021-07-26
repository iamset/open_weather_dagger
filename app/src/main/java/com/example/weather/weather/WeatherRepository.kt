package com.example.weather.weather

import com.example.weather.api.ApiService
import com.example.weather.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api:ApiService) {

    suspend fun getWeather(cityName:String):Response<Weather>{

        return withContext(Dispatchers.IO){
            api.getWeather(cityName, Constants.WEATHER_API_KEY)
        }
    }
}