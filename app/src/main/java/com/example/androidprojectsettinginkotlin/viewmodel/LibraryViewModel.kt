package com.example.androidprojectsettinginkotlin.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidprojectsettinginkotlin.MyApplication
import com.example.androidprojectsettinginkotlin.repository.Repository
import javax.inject.Inject

class LibraryViewModel @Inject constructor(application: MyApplication): AndroidViewModel(application) {
    @Inject
    lateinit var repository: Repository

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun setErrorMessage(errorMessage: String?) {
        _errorMessage.value = errorMessage?: ""
    }
}