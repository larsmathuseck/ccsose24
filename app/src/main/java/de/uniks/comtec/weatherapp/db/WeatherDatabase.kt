package de.uniks.comtec.weatherapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import de.uniks.comtec.weatherapp.model.WeatherData

@Database(entities = [WeatherData::class], version = 1)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}