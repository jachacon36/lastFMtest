package com.example.lastfmtest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Artist (
    @SerializedName("name") @Expose val name: String,
    @SerializedName("url") @Expose val url: String,
    @SerializedName("image") @Expose val image: ArrayList<ImageTemp>
    )
