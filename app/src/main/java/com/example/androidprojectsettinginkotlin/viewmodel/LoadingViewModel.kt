package com.example.androidprojectsettinginkotlin.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.androidprojectsettinginkotlin.MyApplication
import com.example.androidprojectsettinginkotlin.database.entity.User
import com.example.androidprojectsettinginkotlin.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoadingViewModel @Inject constructor(application: MyApplication) : AndroidViewModel(application) {
    @Inject
    lateinit var repository: Repository

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    private val _progressPercent = MutableLiveData<Int>()
    val progressPercent: LiveData<Int> get() = _progressPercent

    private val _isNext = MutableLiveData<Boolean>()
    val isNext: LiveData<Boolean> get() = _isNext

    fun initApp() {
        viewModelScope.launch(Dispatchers.Main) {
            setProgress(0)
            val users: List<User> = repository.initDatabase()
            setProgress(33)
            repository.initSharedPreference()
            setProgress(66)
            repository.initSampleData()
            setProgress(100)

            goNext()
        }
    }

    fun setProgress(value: Int) {
        _progressPercent.value = value
    }

    fun goNext() {
        _isNext.value = true
    }
}