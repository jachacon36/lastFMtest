package com.example.lastfmtest.model

import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class AttrObject (
    @SerializedName("country") @Expose val country: String,
    @SerializedName("page") @Expose val page: String,
    @SerializedName("perPage") @Expose val perPage: String,
    @SerializedName("totalPages") @Expose val totalPages: String,
    @SerializedName("total") @Expose val total: String)
    :Parcelable