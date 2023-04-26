package com.example.androidprojectsettinginkotlin.repository

import com.example.androidprojectsettinginkotlin.database.dao.UserDao
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    val userDao: UserDao
) {
}