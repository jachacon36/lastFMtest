package com.example.lastfmtest.ui

import androidx.lifecycle.MutableLiveData
import com.example.lastfmtest.base.BaseViewModel
import com.example.lastfmtest.model.Artist

class ApiArtistViewModel: BaseViewModel() {
    private val artistName = MutableLiveData<String>()
    private val artistListeners = MutableLiveData<String>()
    private val artistURL = MutableLiveData<String>()

    fun bind(artist: Artist?){
        artistName.value = artist?.name
        artistListeners.value = artist?.listeners
        artistURL.value = artist?.url
    }
    fun getArtistName(): MutableLiveData<String>{
        return this.artistName
    }

    fun getArtistListenrs(): MutableLiveData<String>{
        return this.artistListeners
    }

    fun getArtistURL(): MutableLiveData<String>{
        return this.artistURL
    }
}