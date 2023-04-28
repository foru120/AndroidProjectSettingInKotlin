package com.example.androidprojectsettinginkotlin.dagger.module

import com.example.androidprojectsettinginkotlin.MyApplication
import com.example.androidprojectsettinginkotlin.R
import com.example.androidprojectsettinginkotlin.retrofit.RetrofitAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(application: MyApplication) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(application.applicationContext.getString(R.string.base_url))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesRetrofitAPI(retrofit: Retrofit) : RetrofitAPI {
        return retrofit.create(RetrofitAPI::class.java)
    }
}