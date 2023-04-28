package com.example.androidprojectsettinginkotlin.retrofit

import com.example.androidprojectsettinginkotlin.database.entity.User
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitAPI {
    @GET("users")
    suspend fun getUsers() : Response<List<User>>
}