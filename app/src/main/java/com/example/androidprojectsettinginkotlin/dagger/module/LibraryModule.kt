package com.example.androidprojectsettinginkotlin.dagger.module

import androidx.lifecycle.ViewModel
import com.example.androidprojectsettinginkotlin.dagger.ViewModelKey
import com.example.androidprojectsettinginkotlin.dagger.scope.ActivityScope
import com.example.androidprojectsettinginkotlin.viewmodel.LibraryViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class LibraryModule {
    @ActivityScope
    @Binds
    @IntoMap
    @ViewModelKey(LibraryViewModel::class)
    abstract fun libraryViewModel(libraryViewModel: LibraryViewModel): ViewModel
}