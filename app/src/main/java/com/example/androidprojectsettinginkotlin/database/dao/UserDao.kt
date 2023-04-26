package com.example.androidprojectsettinginkotlin.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.androidprojectsettinginkotlin.database.entity.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user ORDER BY id DESC")
    fun getAllRecordsFromDB(): List<User>?

    @Insert
    fun insertRecord(user: User)
}