package com.parternship.locally.api

import android.content.Context
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/*companion object{

}*/
 class RetrofitClient()  {

companion object{
    const val BASE_URL="localhost:8081"

    @Volatile private var INSTANCE: Retrofit? = null

    fun getInstance(context: Context)  =
        INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildClient(context).also { INSTANCE = it }
        }


        fun buildClient(context: Context) =
             Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create( GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create())).build()

    }
}

