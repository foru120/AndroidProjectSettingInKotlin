package com.example.androidprojectsettinginkotlin.view.loading

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.androidprojectsettinginkotlin.R
import com.example.androidprojectsettinginkotlin.databinding.ActivityLoadingBinding
import com.example.androidprojectsettinginkotlin.view.BaseDaggerAppCompatActivity
import com.example.androidprojectsettinginkotlin.view.CaughtExceptionActivity
import com.example.androidprojectsettinginkotlin.view.splash.SplashActivity
import com.example.androidprojectsettinginkotlin.viewmodel.LoadingViewModel
import javax.inject.Inject

class LoadingActivity : BaseDaggerAppCompatActivity<ActivityLoadingBinding>() {
    override val layout: Int
        get() = R.layout.activity_loading

    @Inject
    lateinit var viewModel: LoadingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpBinding()
        setUpObserve()
        initApp()
    }

    private fun setUpBinding() {
        with(binding) {
            viewModel = this@LoadingActivity.viewModel
        }
    }

    private fun setUpObserve() {
        viewModel.errorMessage.observe(this, Observer {
            val intent = Intent(this, CaughtExceptionActivity::class.java)
            intent.putExtra("errorMessage", it)
            finishAffinity()
            startActivity(intent)
        })

        viewModel.goNext.observe(this, Observer {
            val intent = Intent(this, SplashActivity::class.java)
            finishAffinity()
            startActivity(intent)
        })
    }

    private fun initApp() {
        viewModel.initApp()
    }
}