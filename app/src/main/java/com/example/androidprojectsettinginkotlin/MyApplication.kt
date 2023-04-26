package com.example.androidprojectsettinginkotlin

import android.app.Application
import com.example.androidprojectsettinginkotlin.dagger.DaggerApplicationComponent

class MyApplication : Application() {
    val appComponent = DaggerApplicationComponent.create()
}