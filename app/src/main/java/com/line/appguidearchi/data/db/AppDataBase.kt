package com.line.appguidearchi.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.line.appguidearchi.data.db.dao.UserDao
import com.line.appguidearchi.data.db.entity.User

@Database(entities = [User::class] , version = 1 , exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getUserDao() : UserDao

    companion object {
        const val DB_NAME = "userDB_db"
        private var INSTANCE : AppDataBase? = null

        fun getInstance(context: Context) : AppDataBase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildInstance(context).also { INSTANCE = it }
            }

        fun buildInstance(context: Context) = Room.databaseBuilder(context.applicationContext , AppDataBase::class.java , DB_NAME).build()
    }
}