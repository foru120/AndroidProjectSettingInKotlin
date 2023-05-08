package com.example.androidprojectsettinginkotlin.dagger.module

import androidx.lifecycle.ViewModel
import com.example.androidprojectsettinginkotlin.dagger.ViewModelKey
import com.example.androidprojectsettinginkotlin.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun mainViewModel(mainViewModel: MainViewModel): ViewModel
}