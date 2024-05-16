package de.uniks.comtec.weatherapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import de.uniks.comtec.weatherapp.data.WeatherDataSource
import de.uniks.comtec.weatherapp.data.WeatherRepository
import de.uniks.comtec.weatherapp.db.WeatherDatabase
import de.uniks.comtec.weatherapp.network.WeatherService

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    fun providesRepository(weatherService: WeatherService, db: WeatherDatabase): WeatherRepository {
        val weatherDataSource = WeatherDataSource(weatherService)
        return WeatherRepository(weatherDataSource, db.weatherDao())
    }

}