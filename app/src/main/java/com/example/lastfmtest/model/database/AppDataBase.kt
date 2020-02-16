package com.example.lastfmtest.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lastfmtest.model.GeoTopArtists

@Database(entities = [GeoTopArtists::class],  version = 1)
abstract class AppDataBase:RoomDatabase() {
    abstract fun geoArtistsDao(): GeoArtistsDao
}