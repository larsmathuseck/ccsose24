package de.uniks.comtec.weatherapp.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherResponse(
    @Json(name = "current_condition") val currentCondition: List<CurrentCondition>
)

@JsonClass(generateAdapter = true)
data class CurrentCondition(
    @Json(name = "FeelsLikeC") val feelsLikeC: String,

    @Json(name = "FeelsLikeF") val feelsLikeF: String,

    @Json(name = "humidity") val humidity: String,

    @Json(name = "temp_C") val tempC: String,

    @Json(name = "temp_F") val tempF: String,

    @Json(name = "observation_time") val observationTime: String,
)