package com.example.androidprojectsettinginkotlin.dagger.component

import com.example.androidprojectsettinginkotlin.dagger.scope.ActivityScope
import com.example.androidprojectsettinginkotlin.view.MainActivity
import com.example.androidprojectsettinginkotlin.view.MainFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScope
@Subcomponent
interface MainComponent : AndroidInjector<MainActivity>{
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<MainActivity>{}
    fun inject(mainFragment: MainFragment)
}