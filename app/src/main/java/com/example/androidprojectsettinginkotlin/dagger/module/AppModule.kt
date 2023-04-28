package com.example.androidprojectsettinginkotlin.dagger.module

import android.content.Context
import android.content.SharedPreferences
import com.example.androidprojectsettinginkotlin.MyApplication
import com.example.androidprojectsettinginkotlin.R
import com.example.androidprojectsettinginkotlin.database.AppDatabase
import com.example.androidprojectsettinginkotlin.database.dao.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun getUserDao(appDatabase: AppDatabase): UserDao = appDatabase.getUserDao()

    @Singleton
    @Provides
    fun getRoomInstance(context: Context): AppDatabase {
        return AppDatabase.getAppDatabaseInstance(context)
    }

    @Singleton
    @Provides
    fun providesAppContext(application: MyApplication): Context = application.applicationContext

    @Singleton
    @Provides
    fun providesPreferences(application: MyApplication): SharedPreferences {
        return application.getSharedPreferences(
            application.applicationContext.getString(R.string.base_prefs),
            Context.MODE_PRIVATE
        )
    }
}