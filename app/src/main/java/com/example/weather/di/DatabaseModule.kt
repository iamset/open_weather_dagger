package com.example.weather.di

import android.content.Context
import androidx.room.Room
import com.example.weather.AppDatabase
import com.example.weather.location.LocationDao
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module()
  class DatabaseModule {
        @Singleton
        @Provides
        fun provideDatabase(context:Context): AppDatabase{
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "weather-db"
            ).build()
        }

        @Singleton
        @Provides
        fun provideLocationDao(database: AppDatabase): LocationDao{
            return database.locationDao()
        }





}