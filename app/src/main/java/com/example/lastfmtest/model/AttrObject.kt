package com.example.lastfmtest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

open class AttrObject : RealmObject(){
    @SerializedName("country") @Expose var country: String? = null
    @SerializedName("page") @Expose var page: String? = null
    @SerializedName("perPage") @Expose var perPage: String? = null
    @SerializedName("totalPages") @Expose var totalPages: String? = null
    @SerializedName("total") @Expose var total: String? = null
}