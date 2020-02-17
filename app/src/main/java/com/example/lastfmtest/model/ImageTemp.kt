package com.example.lastfmtest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

open class ImageTemp : RealmObject() {
    @SerializedName("#text") @Expose var text: String? = null
    @SerializedName("size") @Expose var size: String? = null
}
