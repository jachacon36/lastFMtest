package com.example.lastfmtest.ui

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
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
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    init{
        loadArtists()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadArtists() {
        subscription = api.getArtists("geo.gettopartists",
                                                "spain",
                                                "829751643419a7128b7ada50de590067",
                                                "json",
                                                "1"
            )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onStart() }
            .doOnTerminate { onFinish() }
            .subscribe(
                {result-> onSuccess(result) },
                { onError() }
            )
    }

    private fun onStart(){
        loadingVisibility.value = View.VISIBLE
    }

    private fun onFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onSuccess(result:String){
        Log.e("Result", result)
    }

    private fun onError(){

    }

}