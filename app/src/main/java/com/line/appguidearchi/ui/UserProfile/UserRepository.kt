package com.line.appguidearchi.ui.UserProfile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.line.appguidearchi.data.api.webService
import com.line.appguidearchi.data.db.dao.UserDao
import com.line.appguidearchi.data.db.entity.User
import com.line.appguidearchi.util.ioThread
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class UserRepository(val webService: webService , val userDao : UserDao) {

    // Retrofit으로 API 통신하여 Data를 얻을 경우
    /*fun getUser(userID : String) : LiveData<User> {
        val data = MutableLiveData<User>()

        webService.getUser(userID).enqueue(object : Callback, retrofit2.Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
                // 실패
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                // 성공
                data.value = response.body()
            }

        })
        return data
    }*/

    // Room DB에서 가져올 경우
    fun getUser(userID: String) : LiveData<User> {
        apiGetUserData(userID)
        return userDao.load(userID)
    }

    // Room DB를 사용 Thread 추가
    fun apiGetUserData(userID: String) {
        ioThread {
            userDao.insert(webService.getUser(userID).execute().body()!!)
        }
    }
}