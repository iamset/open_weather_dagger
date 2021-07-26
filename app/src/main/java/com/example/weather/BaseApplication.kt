package com.example.weather

import android.app.Application
import com.bumptech.glide.Glide
import com.example.weather.di.ApplicationComponent
import com.example.weather.di.DaggerApplicationComponent

class BaseApplication: Application() {
    lateinit var appComponent:ApplicationComponent

    override fun onCreate() {

        super.onCreate()
        appComponent = DaggerApplicationComponent
            .factory().create(applicationContext)

    }

}