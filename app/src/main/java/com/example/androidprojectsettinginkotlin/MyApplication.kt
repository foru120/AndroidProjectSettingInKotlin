package com.example.androidprojectsettinginkotlin

import com.example.androidprojectsettinginkotlin.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


class MyApplication : DaggerApplication() {
    override fun onCreate() {
        super.onCreate()

        Thread.setDefaultUncaughtExceptionHandler(UncaughtExceptionHandler(this))
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }
}