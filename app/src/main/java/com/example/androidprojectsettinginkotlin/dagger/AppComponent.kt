package com.example.androidprojectsettinginkotlin.dagger

import com.example.androidprojectsettinginkotlin.MyApplication
import com.example.androidprojectsettinginkotlin.dagger.component.MainComponent
import com.example.androidprojectsettinginkotlin.dagger.module.AppModule
import com.example.androidprojectsettinginkotlin.dagger.module.NetworkModule
import com.example.androidprojectsettinginkotlin.dagger.module.SubcomponentsModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, SubcomponentsModule::class])
interface AppComponent {
    fun mainComponent(): MainComponent.Factory

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MyApplication): Builder

        fun build(): AppComponent
    }
}