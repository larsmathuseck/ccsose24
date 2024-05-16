package de.uniks.comtec.weatherapp.network

import retrofit2.http.GET
import retrofit2.http.Path


interface WeatherService {

    @GET("{city}?format=j1")
    suspend fun getWeather(@Path("city") city: String = "Kassel"): WeatherResponse?

}