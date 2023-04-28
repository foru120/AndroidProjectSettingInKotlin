package com.example.androidprojectsettinginkotlin.dagger.module

import com.example.androidprojectsettinginkotlin.dagger.component.MainComponent
import dagger.Module

@Module(subcomponents = [MainComponent::class])
interface SubcomponentsModule {
}