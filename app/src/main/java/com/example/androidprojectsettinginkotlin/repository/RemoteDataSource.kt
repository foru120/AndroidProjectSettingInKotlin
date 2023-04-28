package com.example.androidprojectsettinginkotlin.repository

import com.example.androidprojectsettinginkotlin.retrofit.RetrofitAPI
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val retrofitAPI: RetrofitAPI
) {
}