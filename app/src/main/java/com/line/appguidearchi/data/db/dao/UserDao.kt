package com.line.appguidearchi.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.line.appguidearchi.data.db.entity.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Query("SELECT * FROM user WHERE id = :userID")
    fun load(userID : String) : LiveData<User>

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)
}