package com.example.lastfmtest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TopArtists (
    @SerializedName("artist") @Expose val artist: ArrayList<Artist>
)
