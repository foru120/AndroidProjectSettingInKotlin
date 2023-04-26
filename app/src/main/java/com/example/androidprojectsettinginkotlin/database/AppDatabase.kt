package com.example.androidprojectsettinginkotlin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidprojectsettinginkotlin.database.dao.UserDao
import com.example.androidprojectsettinginkotlin.database.entity.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    companion object {
        private var instance: AppDatabase? = null

        fun getAppDatabaseInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder<AppDatabase>(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_db"
                )
                .allowMainThreadQueries()
                .build()
            }

            return instance!!
        }
    }
}