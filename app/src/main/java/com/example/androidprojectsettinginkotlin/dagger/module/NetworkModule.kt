package com.example.androidprojectsettinginkotlin.dagger.module

import com.example.androidprojectsettinginkotlin.MyApplication
import com.example.androidprojectsettinginkotlin.R
import com.example.androidprojectsettinginkotlin.retrofit.RetrofitAPI
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofitAPI(retrofit: Retrofit) : RetrofitAPI {
        return retrofit.create(RetrofitAPI::class.java)
    }

    @Singleton
    @Provides
    fun providesRetrofit(
        application: MyApplication,
        okHttpClient: OkHttpClient,
        factory: Converter.Factory
    ) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(application.applicationContext.getString(R.string.base_url))
            .client(okHttpClient)
            .addConverterFactory(factory)
            .build()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    fun provideConvertFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }
}