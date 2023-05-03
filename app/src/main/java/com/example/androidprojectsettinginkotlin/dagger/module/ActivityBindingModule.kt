package com.example.androidprojectsettinginkotlin.dagger.module

import com.example.androidprojectsettinginkotlin.dagger.scope.ActivityScope
import com.example.androidprojectsettinginkotlin.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [
        MainActivityModule::class,
        MainFragmentModule::class
    ])
    abstract fun mainActivity(): MainActivity
}