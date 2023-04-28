package com.example.androidprojectsettinginkotlin.dagger.component

import com.example.androidprojectsettinginkotlin.dagger.scope.ActivityScope
import com.example.androidprojectsettinginkotlin.view.MainActivity
import com.example.androidprojectsettinginkotlin.viewmodel.MainFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface MainComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): MainComponent
    }

    fun inject(mainActivity: MainActivity)
    fun inject(mainFragment: MainFragment)
}