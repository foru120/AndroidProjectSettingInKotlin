package com.example.androidprojectsettinginkotlin.dagger

import com.example.androidprojectsettinginkotlin.MyApplication
import com.example.androidprojectsettinginkotlin.dagger.module.ActivityBindingModule
import com.example.androidprojectsettinginkotlin.dagger.module.AppModule
import com.example.androidprojectsettinginkotlin.dagger.module.NetworkModule
import com.example.androidprojectsettinginkotlin.dagger.module.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBindingModule::class,
    AppModule::class,
    ViewModelFactoryModule::class,
    NetworkModule::class])
interface AppComponent : AndroidInjector<MyApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: MyApplication): AppComponent
    }
}