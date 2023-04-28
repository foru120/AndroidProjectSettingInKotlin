package com.example.androidprojectsettinginkotlin.viewmodel

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.androidprojectsettinginkotlin.view.MainActivity
import javax.inject.Inject

class MainFragment : Fragment() {
    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (activity as MainActivity).mainComponent.inject(this)
    }
}