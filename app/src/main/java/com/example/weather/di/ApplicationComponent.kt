package com.example.weather.di

import android.content.Context

import com.example.weather.location.LocationsFragment
import com.example.weather.weather.WeatherFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ViewModelModule::class, NetworkModule::class, DatabaseModule::class))
interface ApplicationComponent {

    fun inject(fragment: WeatherFragment)
    fun inject(fragment: LocationsFragment)

    @Component.Factory
    interface Factory{
        fun create(
            @BindsInstance context: Context,

        ):ApplicationComponent
    }


}