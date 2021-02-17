package com.parternship.locally.api

import com.parternship.locally.entity.Item
import retrofit2.Call
import retrofit2.http.*

interface SubscriptionEndpoints {

  @GET("/subscription/{id}")
  @Headers("Accept: application/json;charset=utf-8")
  fun getSubscription (@Path("id")  id : String) : Call<Item>


    @POST("/subscription")
    @Headers("Accept: application/json;charset=utf-8")
    fun postSubscription (@Body item :Item) : Call<String>


    @PUT("/subscription")
    @Headers("Accept: application/json;charset=utf-8")
    fun putSubscription (@Body item :Item) : Call<String>

    @DELETE("subscription/{id}")
    @Headers("Accept: application/json;charset=utf-8")
    fun deleteItem (@Path("id") id :String ) : Call<Unit>


}