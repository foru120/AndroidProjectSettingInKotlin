package com.example.androidprojectsettinginkotlin.dagger

import com.example.androidprojectsettinginkotlin.dagger.module.AppModule
import com.example.androidprojectsettinginkotlin.dagger.module.NetworkModule
import com.example.androidprojectsettinginkotlin.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}