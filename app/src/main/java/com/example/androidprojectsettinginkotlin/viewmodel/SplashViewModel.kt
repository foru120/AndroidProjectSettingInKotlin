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
    private var _isNext = MutableLiveData<Boolean>()
    val isNext: LiveData<Boolean> get() = _isNext

    fun goNext() {
        _isNext.value = true
    }
}