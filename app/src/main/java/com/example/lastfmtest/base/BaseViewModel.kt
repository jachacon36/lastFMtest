package com.example.lastfmtest.base

import androidx.lifecycle.ViewModel
import com.example.lastfmtest.injection.component.DaggerViewModelInjector
import com.example.lastfmtest.injection.component.ViewModelInjector
import com.example.lastfmtest.injection.module.NetworkModule
import com.example.lastfmtest.ui.ApiViewModel

abstract class BaseViewModel:ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is ApiViewModel -> injector.inject(this)
        }
    }
}