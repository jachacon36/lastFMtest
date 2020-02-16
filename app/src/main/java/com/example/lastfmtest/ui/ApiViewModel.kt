package com.example.lastfmtest.ui

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.lastfmtest.R
import com.example.lastfmtest.base.BaseViewModel
import com.example.lastfmtest.model.geoTopArtists
import com.example.lastfmtest.network.Api
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import org.json.JSONObject
import javax.inject.Inject

class ApiViewModel():BaseViewModel() {
    @Inject
    lateinit var api: Api
    private lateinit var subscription: Disposable
    private lateinit var topArtists : geoTopArtists
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadArtists() }
    val artistAdapter: ArtistsAdapter = ArtistsAdapter()
    var gson : Gson = Gson()
    var totalPages: Int = 0
    var pageCurrent: Int = 1


    init{
        loadArtists()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    fun loadArtists() {
        subscription = api.getArtists("geo.gettopartists",
                                                "spain",
                                                "829751643419a7128b7ada50de590067",
                                                "json",
                                                getPage()
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
        errorMessage.value = null

    }

    private fun onFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onSuccess(result: ResponseBody){
        val obj = JSONObject(result.string())
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setDateFormat("M/d/yy hh:mm a")
        gson = gsonBuilder.create()
        topArtists = gson.fromJson(obj.toString(), geoTopArtists::class.java)
        totalPages = topArtists.topartists.attrObject.totalPages.toInt()
        artistAdapter.updatePostList(topArtists.topartists.artist)
    }

    private fun onError(){
        errorMessage.value = R.string.error
    }

    private fun getPage():String{
           when{
               pageCurrent <= totalPages->{pageCurrent+=1}
           }
        return pageCurrent.toString()

    }

}