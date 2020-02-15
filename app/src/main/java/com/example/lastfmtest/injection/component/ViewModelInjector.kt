package com.example.lastfmtest.injection.component

import com.example.lastfmtest.injection.module.NetworkModule
import com.example.lastfmtest.ui.ApiViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(apiViewModel: ApiViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector
        fun networkModule(networkModule: NetworkModule): Builder}
}