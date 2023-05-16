package com.example.androidprojectsettinginkotlin.dagger.module

import androidx.lifecycle.ViewModel
import com.example.androidprojectsettinginkotlin.dagger.ViewModelKey
import com.example.androidprojectsettinginkotlin.dagger.scope.ActivityScope
import com.example.androidprojectsettinginkotlin.viewmodel.LoadingViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class LoadingModule {
    @ActivityScope
    @Binds
    @IntoMap
    @ViewModelKey(LoadingViewModel::class)
    abstract fun loadingViewModel(loadingViewModel: LoadingViewModel): ViewModel
}