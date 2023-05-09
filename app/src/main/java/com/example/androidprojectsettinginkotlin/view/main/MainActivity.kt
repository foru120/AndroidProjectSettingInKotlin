package com.example.androidprojectsettinginkotlin.view.main

import android.os.Bundle
import com.example.androidprojectsettinginkotlin.R
import com.example.androidprojectsettinginkotlin.databinding.ActivityMainBinding
import com.example.androidprojectsettinginkotlin.view.BaseDaggerAppCompatActivity
import com.example.androidprojectsettinginkotlin.viewmodel.MainViewModel
import javax.inject.Inject

class MainActivity : BaseDaggerAppCompatActivity<ActivityMainBinding>() {

    override val layout: Int
        get() = R.layout.activity_main

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpBinding()
    }

    private fun setUpBinding() {
        with(binding) {
            viewModel = this@MainActivity.viewModel
        }
    }
}