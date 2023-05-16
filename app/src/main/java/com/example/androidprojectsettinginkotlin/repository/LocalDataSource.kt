package com.example.androidprojectsettinginkotlin.repository

import com.example.androidprojectsettinginkotlin.database.dao.UserDao
import com.example.androidprojectsettinginkotlin.database.entity.User
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    val userDao: UserDao
) {
    suspend fun initDatabase(): List<User> {
        return userDao.getAllRecordsFromDB()
    }

    suspend fun initSampleData() {
        val userList = arrayListOf<User>(
            User(desc = "Luka"),
            User(desc = "Kein"),
            User(desc = "Prod")
        )

        userDao.insertAll(userList)
    }
}