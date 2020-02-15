package com.example.lastfmtest.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImageTemp (
    @SerializedName("#text") @Expose val text: String,
    @SerializedName("size") @Expose val size: String
    ):Parcelable
