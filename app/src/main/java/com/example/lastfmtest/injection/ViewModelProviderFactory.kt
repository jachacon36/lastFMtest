package com.example.lastfmtest.injection

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lastfmtest.ui.ApiViewModel
import io.realm.Realm
import io.realm.RealmConfiguration

class ViewModelProviderFactory(private val activity: AppCompatActivity):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ApiViewModel::class.java)) {
            val realm = initRealmConfiguration(activity)
            @Suppress("UNCHECKED_CAST")
            return ApiViewModel(realm) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

    private fun initRealmConfiguration(activity: AppCompatActivity): Realm? {
        Realm.init(activity)
        val realmConfiguration = RealmConfiguration.Builder()
            .name(Realm.DEFAULT_REALM_NAME)
            .schemaVersion(0)
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(realmConfiguration)
        return Realm.getDefaultInstance()
    }

}