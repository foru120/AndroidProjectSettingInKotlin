package com.example.androidprojectsettinginkotlin.view.splash

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.androidprojectsettinginkotlin.R
import com.example.androidprojectsettinginkotlin.databinding.FragmentFirstSplashBinding
import com.example.androidprojectsettinginkotlin.viewmodel.SplashViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class FirstSplashFragment @Inject constructor() : Fragment() {

    @Inject
    lateinit var viewModel: SplashViewModel

    private lateinit var _binding: FragmentFirstSplashBinding
    val binding: FragmentFirstSplashBinding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first_splash, container, false)

        return binding.root
    }
}