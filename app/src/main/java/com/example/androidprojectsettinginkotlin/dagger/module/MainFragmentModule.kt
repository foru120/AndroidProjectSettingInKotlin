package com.example.androidprojectsettinginkotlin.dagger.module

import com.example.androidprojectsettinginkotlin.view.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentModule {
    @ContributesAndroidInjector
    abstract fun fragmentMain(): MainFragment
}