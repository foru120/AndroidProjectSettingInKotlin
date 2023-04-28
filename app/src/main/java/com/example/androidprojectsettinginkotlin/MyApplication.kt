package com.example.androidprojectsettinginkotlin

import android.app.Application
import com.example.androidprojectsettinginkotlin.dagger.AppComponent
import com.example.androidprojectsettinginkotlin.dagger.DaggerAppComponent

class MyApplication : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
    }
}