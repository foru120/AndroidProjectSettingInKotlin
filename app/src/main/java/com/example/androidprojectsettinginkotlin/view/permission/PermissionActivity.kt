package com.example.androidprojectsettinginkotlin.view.permission

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.androidprojectsettinginkotlin.R
import com.example.androidprojectsettinginkotlin.databinding.ActivityPermissionBinding
import com.example.androidprojectsettinginkotlin.view.BaseDaggerAppCompatActivity
import com.example.androidprojectsettinginkotlin.view.CaughtExceptionActivity
import com.example.androidprojectsettinginkotlin.view.loading.LoadingActivity
import com.example.androidprojectsettinginkotlin.view.splash.SplashActivity
import com.example.androidprojectsettinginkotlin.viewmodel.PermissionViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class PermissionActivity : BaseDaggerAppCompatActivity<ActivityPermissionBinding>() {

    override val layout
        get() = R.layout.activity_permission

    @Inject
    lateinit var viewModel: PermissionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpBinding()
        setUpObserve()
    }

    private fun setUpBinding() {
        with(binding) {
            binding.viewModel = viewModel
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
            val intent = Intent(this, LoadingActivity::class.java)
            finishAffinity()
            startActivity(intent)
        })
    }
}