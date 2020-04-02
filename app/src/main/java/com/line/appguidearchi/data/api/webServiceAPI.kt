package com.line.appguidearchi.data.api

import com.line.appguidearchi.data.db.entity.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface webService {
    @GET("/users/{user}")
    fun getUser(@Path("user") userID : String) : Call<User>
}