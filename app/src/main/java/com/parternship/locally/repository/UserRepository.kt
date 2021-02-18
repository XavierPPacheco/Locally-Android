package com.parternship.locally.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.parternship.locally.api.UserEndpoints
import com.parternship.locally.entity.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {


    var retrofit = UserEndpoints.Companion

    fun getUserDetails() : LiveData<User> {

        var data = MutableLiveData<User>()

      retrofit.create().getUser().enqueue(object : Callback<User>{
          override fun onFailure(call: Call<User>, t: Throwable) {

          }

          override fun onResponse(call: Call<User>, response: Response<User>) {
            data.value=response.body()
          }

      })

    return data
    }

}