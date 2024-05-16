package de.uniks.comtec.weatherapp.data

import de.uniks.comtec.weatherapp.db.WeatherDao
import de.uniks.comtec.weatherapp.model.WeatherData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class WeatherRepository(weatherDataSource: WeatherDataSource, private val weatherDao: WeatherDao) {

    val weatherDbFlow = weatherDao.getWeatherFlow()
    val loadingFlow = weatherDataSource.loadingState

    init {
        CoroutineScope(Dispatchers.IO).launch {
            weatherDataSource.latestWeather.collect { weather ->
                weatherDao.upsertWeather(weather)
            }
        }
    }


}