package com.example.lastfmtest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject

open class Artist : RealmObject() {
    @SerializedName("name") @Expose var name: String? = null
    @SerializedName("listeners") @Expose var listeners: String? = null
    @SerializedName("url") @Expose var url: String? = null
    @SerializedName("image") @Expose var image: RealmList<ImageTemp>? = null
}
