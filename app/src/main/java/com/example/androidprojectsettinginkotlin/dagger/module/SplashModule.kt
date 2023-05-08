package com.example.androidprojectsettinginkotlin.dagger.module

import androidx.lifecycle.ViewModel
import com.example.androidprojectsettinginkotlin.dagger.ViewModelKey
import com.example.androidprojectsettinginkotlin.dagger.scope.ActivityScope
import com.example.androidprojectsettinginkotlin.viewmodel.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SplashModule {
    @ActivityScope
    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun splashViewModel(splashViewModel: SplashViewModel): ViewModel
}