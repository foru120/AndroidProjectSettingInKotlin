package com.example.androidprojectsettinginkotlin.repository

import android.content.SharedPreferences
import android.text.TextUtils
import com.example.androidprojectsettinginkotlin.constants.PREFS_LOGIN_ID
import com.example.androidprojectsettinginkotlin.constants.PREFS_VISIBLE_BANNER_SCREEN
import com.example.androidprojectsettinginkotlin.constants.PREFS_VISIBLE_SPLASH_SCREEN
import com.example.androidprojectsettinginkotlin.database.entity.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    suspend fun initDatabase(): List<User> = withContext(Dispatchers.IO) {
        delay(1000)
        return@withContext localDataSource.initDatabase()
    }

    suspend fun initSharedPreference() {
        withContext(Dispatchers.IO) {
            delay(1000)

            if (TextUtils.isEmpty(sharedPreferences.getString(PREFS_LOGIN_ID, ""))) {
                sharedPreferences.edit().putBoolean(PREFS_VISIBLE_SPLASH_SCREEN, true).apply()
                sharedPreferences.edit().putBoolean(PREFS_VISIBLE_BANNER_SCREEN, true).apply()
            }
        }
    }

    suspend fun initSampleData() {
        withContext(Dispatchers.IO) {
            delay(1000)

            localDataSource.initSampleData()
        }
    }
}