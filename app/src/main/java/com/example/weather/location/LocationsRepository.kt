package com.example.weather.location

import androidx.lifecycle.MutableLiveData
import com.example.weather.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocationsRepository @Inject constructor(private val locationDao: LocationDao) {

    suspend fun getLocations(): List<Location>{
        return withContext(Dispatchers.IO){
            locationDao.getLocations()
        }
    }

    suspend fun insertLocation(location: Location){
        return withContext(Dispatchers.IO){
            locationDao.insertLocation(location)
        }
    }
}