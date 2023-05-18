package com.example.androidprojectsettinginkotlin.dagger.module

import androidx.lifecycle.ViewModel
import com.example.androidprojectsettinginkotlin.dagger.ViewModelKey
import com.example.androidprojectsettinginkotlin.viewmodel.PermissionViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PermissionModule {
    @Binds
    @IntoMap
    @ViewModelKey(PermissionViewModel::class)
    abstract fun permissionViewModel(permissionViewModel: PermissionViewModel): ViewModel
}