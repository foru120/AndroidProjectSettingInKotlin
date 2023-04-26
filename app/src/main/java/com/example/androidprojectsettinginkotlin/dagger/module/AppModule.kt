package com.example.androidprojectsettinginkotlin.dagger.module

import android.content.Context
import com.example.androidprojectsettinginkotlin.MyApplication
import com.example.androidprojectsettinginkotlin.database.AppDatabase
import com.example.androidprojectsettinginkotlin.database.dao.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val application: MyApplication) {

    @Singleton
    @Provides
    fun getUserDao(appDatabase: AppDatabase): UserDao = appDatabase.getUserDao()

    @Singleton
    @Provides
    fun getRoomInstance(): AppDatabase {
        return AppDatabase.getAppDatabaseInstance()
    }

    @Singleton
    @Provides
    fun prodiveAppContext(): Context = application.applicationContext
}