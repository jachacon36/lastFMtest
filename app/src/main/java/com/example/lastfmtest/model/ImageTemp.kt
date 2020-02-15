package com.example.lastfmtest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ImageTemp (
    @SerializedName("#text") @Expose val text: String,
    @SerializedName("size") @Expose val size: String
    )
