package com.example.lastfmtest.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject

open class TopArtists : RealmObject() {
    @SerializedName("artist") @Expose var artist: RealmList<Artist>? = null
    @SerializedName("@attr") @Expose var attrObject: AttrObject? = null
}
