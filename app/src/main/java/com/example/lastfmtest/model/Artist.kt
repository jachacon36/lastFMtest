package com.example.lastfmtest.model

import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Artist (
    @SerializedName("name") @Expose val name: String,
    @SerializedName("listeners") @Expose val listeners: String,
    @SerializedName("url") @Expose val url: String,
    @SerializedName("image") @Expose val image: ArrayList<ImageTemp>
    ): Parcelable
