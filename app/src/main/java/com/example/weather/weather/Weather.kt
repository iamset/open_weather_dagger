package com.example.weather.weather

import java.util.*

data class Weather (
    val cord: Cord,
    val weather: List<WeatherDetails>,
    val base: String,
    val main: Main,
    val visibility:Int,
    val wind: Wind,
    val clouds: Cloud,
    val dt:Int,
    val sys: Sys,
    val timeZone: Int,
    val id: Long,
    val name:String,
    val cod: Int
        )
data class Cord(
    val lon:Int,
    val lat:Int
)

data class WeatherDetails(
    val id:Int,
    val main:String,
    val description:String,
    val icon: String
)

data class Main(
    val temp:Double,
    val feels_like:Double,
    val temp_min:Double,
    val temp_max: Double,
    val pressure: Int,
    val humidity: Int
)

data class Wind(
    val speed: Double,
    val deg: Int
)
data class Cloud(
    val all:Int
)

data class Sys(
    val type:Int,
    val id:Int,
    val message: Double,
    val country:String,
    val sunrise:Long,
    val sunset: Long,

)