package com.example.androidprojectsettinginkotlin.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.androidprojectsettinginkotlin.database.entity.User

@Dao
interface UserDao : BaseDao<User> {
    @Query("SELECT * FROM user ORDER BY id DESC")
    suspend fun getAllRecordsFromDB(): List<User>
}