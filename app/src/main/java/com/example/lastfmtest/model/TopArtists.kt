package com.example.lastfmtest.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TopArtists (
    @SerializedName("artist") @Expose val artist: ArrayList<Artist>
): Parcelable
