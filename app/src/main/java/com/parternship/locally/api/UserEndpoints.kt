package com.parternship.locally.api

import com.google.gson.GsonBuilder
import com.parternship.locally.entity.Item
import com.parternship.locally.entity.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface UserEndpoints {

    @GET("/user")
    @Headers("Accept: application/json;charset=utf-8")
      fun getUser () : Call<User>

    companion object{
        const val BASE_URL="localhost:8081"

        fun create() : UserEndpoints{
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

            return retrofit.create(UserEndpoints::class.java)
        }

    }

}