package com.example.androidprojectsettinginkotlin.dagger.module

import androidx.lifecycle.ViewModelProvider
import com.example.androidprojectsettinginkotlin.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class FactoryModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}