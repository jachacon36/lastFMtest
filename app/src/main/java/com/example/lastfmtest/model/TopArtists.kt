package com.example.lastfmtest.model

import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class TopArtists (
    @SerializedName("artist") @Expose val artist: ArrayList<Artist>,
    @SerializedName("@attr") @Expose val attrObject: AttrObject
): Parcelable
