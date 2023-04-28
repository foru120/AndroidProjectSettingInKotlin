package com.example.androidprojectsettinginkotlin.viewmodel

import androidx.lifecycle.AndroidViewModel
import com.example.androidprojectsettinginkotlin.MyApplication
import com.example.androidprojectsettinginkotlin.dagger.scope.ActivityScope
import com.example.androidprojectsettinginkotlin.repository.Repository
import javax.inject.Inject

@ActivityScope
class MainViewModel @Inject constructor(
    private val application: MyApplication,
    private val repository: Repository
) : AndroidViewModel(application) {
}