package com.example.lastfmtest.network

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("/2.0/")
    fun getArtists(@Query("method") method: String,
                   @Query("country") country: String,
                   @Query("api_key") api_key: String,
                   @Query("format") format: String,
                   @Query("page") page: String
                   ): Observable<ResponseBody>

}