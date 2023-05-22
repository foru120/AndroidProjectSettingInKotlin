package com.example.androidprojectsettinginkotlin.viewmodel

import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidprojectsettinginkotlin.MyApplication
import com.example.androidprojectsettinginkotlin.repository.Repository
import javax.inject.Inject

class PermissionViewModel @Inject constructor(application: MyApplication) : AndroidViewModel(application) {
    @Inject
    lateinit var repository: Repository

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    private val _isNext = MutableLiveData<Boolean>()
    val isNext: LiveData<Boolean> get() = _isNext

    private val _isRequestPermission = MutableLiveData<Boolean>()
    val isRequestPermission: LiveData<Boolean> get() = _isRequestPermission

    fun goNext() {
        _isNext.value = true
    }

    fun requestPermission() {
        Log.d("kyh", "viewmodel: requestPermission")
        _isRequestPermission.value = true
    }
}