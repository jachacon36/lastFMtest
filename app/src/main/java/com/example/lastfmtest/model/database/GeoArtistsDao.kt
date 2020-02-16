package com.example.lastfmtest.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lastfmtest.model.GeoTopArtists

@Dao
interface GeoArtistsDao {
    @get:Query("SELECT * FROM geoTopArtists")
    val all: GeoTopArtists

    @Insert
    fun insertAll(vararg artists: GeoTopArtists)
}