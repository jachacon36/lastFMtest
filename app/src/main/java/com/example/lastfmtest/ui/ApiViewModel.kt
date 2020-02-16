package com.example.lastfmtest.ui

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.lastfmtest.R
import com.example.lastfmtest.base.BaseViewModel
import com.example.lastfmtest.model.geoTopArtists
import com.example.lastfmtest.network.Api
import com.example.lastfmtest.utils.*
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
    val errorClickListener = View.OnClickListener { loadArtists(false) }
    val artistAdapter: ArtistsAdapter = ArtistsAdapter()
    private var gson : Gson = Gson()
    private val totalPages: MutableLiveData<Int> = MutableLiveData()
    val pageCurrent: MutableLiveData<Int> = MutableLiveData()
    var page = ONE
    var oneCall = false

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
    fun loadArtists(inCall : Boolean) {
        if (!inCall){
            subscription = api.getArtists(METHOD,COUNTRY, API_KEY, FORMAT, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onStart() }
                .doOnTerminate { onFinish() }
                .subscribe(
                    {result-> onSuccess(result) },
                    { onError() }
                )
        }

    }

    private fun onStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
        oneCall = true

    }

    private fun onFinish(){
        loadingVisibility.value = View.GONE
        oneCall = false
    }

    private fun onSuccess(result: ResponseBody){
        topArtists = gson.fromJson(createJSONObject(result), geoTopArtists::class.java)
        totalPages.value = topArtists.topartists.attrObject.totalPages.toInt()
        pageCurrent.value=topArtists.topartists.attrObject.page.toInt()
        artistAdapter.updatePostList(topArtists.topartists.artist)

    }

    private fun onError(){
        errorMessage.value = R.string.error
    }

    fun getPageCurrent():String{
        return page
    }

    private fun createJSONObject(result: ResponseBody): String{
        val jsonObject = JSONObject(result.string())
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setDateFormat(DATE_FORMAT)
        gson = gsonBuilder.create()
        return jsonObject.toString()
    }

}