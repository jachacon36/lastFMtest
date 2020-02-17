package com.example.lastfmtest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

open class GeoTopArtists : RealmObject(){
    @SerializedName("topartists") @Expose var topartists: TopArtists? = null
}