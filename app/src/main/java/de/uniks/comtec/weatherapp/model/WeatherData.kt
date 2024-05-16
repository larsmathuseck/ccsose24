package de.uniks.comtec.weatherapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import de.uniks.comtec.weatherapp.network.WeatherResponse


@Entity
data class WeatherData(
    @PrimaryKey val uid: Int = 1,
    val humidity: Double,
    val tempC: Double,
)

fun WeatherResponse?.toWeatherData(): WeatherData? {
    this?.currentCondition?.getOrNull(0)?.let {
        val humidity = it.humidity.toDoubleOrNull()
        val tempC = it.tempC.toDoubleOrNull()
        if (humidity != null && tempC != null) {
            return WeatherData(humidity = humidity, tempC = tempC)
        }
    }
    return null
}