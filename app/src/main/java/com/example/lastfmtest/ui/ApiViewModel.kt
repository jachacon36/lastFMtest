package com.example.lastfmtest.ui

import com.example.lastfmtest.base.BaseViewModel
import com.example.lastfmtest.network.Api
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ApiViewModel():BaseViewModel() {
    @Inject
    lateinit var api: Api
    private lateinit var subscription: Disposable

    init{
        loadArtists()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadArtists() {
        subscription = api.getArtists()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onStart() }
            .doOnTerminate { onFinish() }
            .subscribe(
                { onSuccess() },
                { onError() }
            )
    }

    private fun onStart(){

    }

    private fun onFinish(){

    }

    private fun onSuccess(){

    }

    private fun onError(){

    }

}