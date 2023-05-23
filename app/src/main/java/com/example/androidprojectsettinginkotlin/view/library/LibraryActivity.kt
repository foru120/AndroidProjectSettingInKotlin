package com.example.androidprojectsettinginkotlin.view.library

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.androidprojectsettinginkotlin.R
import com.example.androidprojectsettinginkotlin.databinding.ActivityLibraryBinding
import com.example.androidprojectsettinginkotlin.view.BaseDaggerAppCompatActivity
import com.example.androidprojectsettinginkotlin.view.CaughtExceptionActivity
import com.example.androidprojectsettinginkotlin.viewmodel.LibraryViewModel
import javax.inject.Inject

class LibraryActivity : BaseDaggerAppCompatActivity<ActivityLibraryBinding>() {
    override val layout: Int
        get() = R.layout.activity_library

    @Inject
    lateinit var viewModel: LibraryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpBinding()
        setUpObserve()
    }

    private fun setUpBinding() {
        with(binding) {
            viewModel = this@LibraryActivity.viewModel
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