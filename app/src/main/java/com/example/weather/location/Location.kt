package com.example.weather.location


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Location (
    @PrimaryKey val name:String
        )