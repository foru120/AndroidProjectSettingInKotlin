package com.example.androidprojectsettinginkotlin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidprojectsettinginkotlin.MyApplication
import com.example.androidprojectsettinginkotlin.repository.Repository
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val application: MyApplication,
    private val repository: Repository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(application, repository) as T
        }
        throw IllegalArgumentException("Unable to construct viewmodel")
    }
}