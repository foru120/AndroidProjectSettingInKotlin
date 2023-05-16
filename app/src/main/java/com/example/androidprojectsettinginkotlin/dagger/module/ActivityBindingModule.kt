package com.example.androidprojectsettinginkotlin.dagger.module

import com.example.androidprojectsettinginkotlin.dagger.scope.ActivityScope
import com.example.androidprojectsettinginkotlin.view.loading.LoadingActivity
import com.example.androidprojectsettinginkotlin.view.main.MainActivity
import com.example.androidprojectsettinginkotlin.view.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [
        MainModule::class
    ])
    abstract fun mainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [
        SplashModule::class
    ])
    abstract fun splashActivity(): SplashActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [
        LoadingModule::class
    ])
    abstract fun loadingActivity(): LoadingActivity
}