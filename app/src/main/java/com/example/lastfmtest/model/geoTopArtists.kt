package com.example.lastfmtest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class geoTopArtists (
    @SerializedName("topartists") @Expose val topartists: TopArtists,
    @SerializedName("@attr") @Expose val attr: Attr_
)