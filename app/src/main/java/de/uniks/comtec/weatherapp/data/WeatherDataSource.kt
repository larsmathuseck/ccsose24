package de.uniks.comtec.weatherapp.data

import de.uniks.comtec.weatherapp.model.toWeatherData
import de.uniks.comtec.weatherapp.network.WeatherService
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow

class WeatherDataSource(
    private val weatherService: WeatherService
) {
    val loadingState = MutableStateFlow(false)
    val latestWeather = flow {
        while (true) {
            loadingState.value = true
            val w = weatherService.getWeather()
            w?.toWeatherData()?.let {
                delay(1800)
                this.emit(it)
            }
            loadingState.value = false
            delay(10000)
        }
    }
}