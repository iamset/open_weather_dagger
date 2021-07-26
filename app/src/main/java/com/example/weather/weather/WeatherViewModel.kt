package com.example.weather.weather

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch
import java.util.regex.Pattern
import javax.inject.Inject

class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
    ): ViewModel() {

    val result: MutableLiveData<Weather> = MutableLiveData()

    fun getWeather(cityName:String){
        viewModelScope.launch {
            val response = repository.getWeather(cityName)
            if(response.isSuccessful){
                result.value = response.body()
            } else {

            }
        }
    }
}