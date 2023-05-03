package com.example.androidprojectsettinginkotlin.view

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.androidprojectsettinginkotlin.viewmodel.MainViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MainFragment : DaggerFragment() {
    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel by viewModels<MainViewModel> {factory}

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }
}