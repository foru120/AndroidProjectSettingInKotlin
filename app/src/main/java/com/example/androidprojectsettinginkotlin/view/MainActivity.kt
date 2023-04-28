package com.example.androidprojectsettinginkotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.androidprojectsettinginkotlin.MyApplication
import com.example.androidprojectsettinginkotlin.R
import com.example.androidprojectsettinginkotlin.dagger.component.MainComponent
import com.example.androidprojectsettinginkotlin.databinding.ActivityMainBinding
import com.example.androidprojectsettinginkotlin.viewmodel.MainViewModel
import com.example.androidprojectsettinginkotlin.viewmodel.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var mainComponent: MainComponent
    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        mainComponent = (applicationContext as MyApplication).appComponent.mainComponent().create()
        mainComponent.inject(this)

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setUpActivity()
    }

    private fun setUpActivity() {
        binding.lifecycleOwner = this
        binding.viewModel = mainViewModel
    }
}