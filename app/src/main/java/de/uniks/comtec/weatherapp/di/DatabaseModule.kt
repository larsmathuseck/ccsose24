package de.uniks.comtec.weatherapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import de.uniks.comtec.weatherapp.data.WeatherDataSource
import de.uniks.comtec.weatherapp.data.WeatherRepository
import de.uniks.comtec.weatherapp.db.WeatherDatabase
import de.uniks.comtec.weatherapp.network.WeatherService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext applicationContext: Context): WeatherDatabase {
        val db = Room.databaseBuilder(
            applicationContext, WeatherDatabase::class.java, "weather-db"
        ).build()
        return db
    }

}