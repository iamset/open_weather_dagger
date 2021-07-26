package com.example.weather

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weather.location.Location
import com.example.weather.location.LocationDao

@Database(entities = arrayOf(Location::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun locationDao(): LocationDao
}