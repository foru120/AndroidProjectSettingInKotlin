package com.example.androidprojectsettinginkotlin.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidprojectsettinginkotlin.MyApplication
import com.example.androidprojectsettinginkotlin.dagger.scope.ActivityScope
import javax.inject.Inject

@ActivityScope
class SplashViewModel @Inject constructor(
    private val application: MyApplication
) : AndroidViewModel(application) {
    private val _isNext = MutableLiveData<Boolean>()
    val isNext: LiveData<Boolean> get() = _isNext

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun goNext() {
        _isNext.value = true
    }
}