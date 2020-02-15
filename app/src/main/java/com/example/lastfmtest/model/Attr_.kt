package com.example.lastfmtest.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Attr_ (
    @SerializedName("country") @Expose val country: String,
    @SerializedName("country") @Expose val page: String,
    @SerializedName("perPage") @Expose val perPage: String,
    @SerializedName("totalPages") @Expose val totalPages: String,
    @SerializedName("total") @Expose val total: String):Parcelable