package com.example.androidprojectsettinginkotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.androidprojectsettinginkotlin.repository.Repository
import javax.inject.Inject

class MainViewModel @Inject constructor(
    application: Application,
    private val repository: Repository
) : AndroidViewModel(application) {
}