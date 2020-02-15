package com.example.lastfmtest.ui

import com.example.lastfmtest.base.BaseViewModel
import com.example.lastfmtest.network.Api
import javax.inject.Inject

class ApiViewModel():BaseViewModel() {
    @Inject
    lateinit var api: Api

}