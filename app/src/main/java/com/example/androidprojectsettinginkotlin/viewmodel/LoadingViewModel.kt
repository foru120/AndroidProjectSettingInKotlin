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

    private val _goNext = MutableLiveData<Boolean>()
    val goNext: LiveData<Boolean> get() = _goNext

    fun initApp() {
        viewModelScope.launch(Dispatchers.Main) {
            _progressPercent.value = 0
            val users: List<User> = repository.initDatabase()
            _progressPercent.value = 33
            repository.initSharedPreference()
            _progressPercent.value = 66
            repository.initSampleData()
            _progressPercent.value = 100

            _goNext.value = true
        }
    }
}