package com.line.appguidearchi.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val id : String ,
    val age : Int ,
    val name : String)