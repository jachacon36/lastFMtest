package com.example.lastfmtest.network

import com.example.lastfmtest.model.geoTopArtists
import io.reactivex.Observable
import retrofit2.http.GET

interface Api {
    @GET()
    fun getArtists(): Observable<geoTopArtists>
}