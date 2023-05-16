package com.example.androidprojectsettinginkotlin.database.dao

import androidx.room.*

@Dao
interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(obj: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(objList: ArrayList<T>)

    @Update
    fun update(obj: T)

    @Delete
    fun delete(obj: T)
}