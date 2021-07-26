package com.example.weather.location

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocationsViewModel @Inject constructor(private val repository: LocationsRepository): ViewModel() {

    val data: MutableLiveData<List<Location>> = MutableLiveData<List<Location>>()

    fun getLocations(){
        viewModelScope.launch {
            val result = repository.getLocations()
            if(result.isEmpty()){

            } else {
                data.value = result

            }
        }
    }

    fun insertLocation(location: Location){
        viewModelScope.launch {
            repository.insertLocation(location)
            getLocations()
        }
    }

}