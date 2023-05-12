package com.example.androidprojectsettinginkotlin.view.main

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.androidprojectsettinginkotlin.R
import com.example.androidprojectsettinginkotlin.databinding.ActivityMainBinding
import com.example.androidprojectsettinginkotlin.view.BaseDaggerAppCompatActivity
import com.example.androidprojectsettinginkotlin.view.CaughtExceptionActivity
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
        setUpObserve()
    }

    private fun setUpBinding() {
        with(binding) {
            viewModel = this@MainActivity.viewModel
        }
    }

    private fun setUpObserve() {
        viewModel.errorMessage.observe(this, Observer {
            val intent = Intent(this, CaughtExceptionActivity::class.java)
            intent.putExtra("errorMessage", it)
            finishAffinity()
            startActivity(intent)
        })
    }
}