package de.uniks.comtec.weatherapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import de.uniks.comtec.weatherapp.model.WeatherData
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

    @Query("SELECT * FROM weatherdata LIMIT 1")
    fun getWeatherFlow(): Flow<WeatherData?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsertWeather(weatherData: WeatherData)
}