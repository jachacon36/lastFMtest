package com.example.lastfmtest.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class geoTopArtists (
    @SerializedName("topartists") @Expose val topartists: TopArtists,
    @SerializedName("@attr") @Expose val attr: Attr_
):Parcelable