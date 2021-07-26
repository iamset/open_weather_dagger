package com.example.weather.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weather.ViewModelFactory
import com.example.weather.ViewModelKey
import com.example.weather.location.LocationsFragment
import com.example.weather.location.LocationsViewModel

import com.example.weather.weather.WeatherViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(WeatherViewModel::class)
    internal abstract fun WeatherViewModel(viewModel: WeatherViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(LocationsViewModel::class)
    internal abstract fun LocationsViewModel(viewModel: LocationsViewModel): ViewModel

    //Add more ViewModels here
}