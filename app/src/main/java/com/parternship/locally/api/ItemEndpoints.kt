package com.parternship.locally.api

import com.parternship.locally.entity.Item
import retrofit2.Call
import retrofit2.http.*

interface ItemEndpoints {

    @GET("/item/{id}")
    @Headers("Accept: application/json;charset=utf-8")
    fun getItem (@Path("id")  id : String) : Call<Item>

    @POST("/item")
    @Headers("Accept: application/json;charset=utf-8")
    fun postItem (@Body  item : Item) : Call<String>

    @PUT("/item")
    @Headers("Accept: application/json;charset=utf-8")
    fun putItem (@Body item :Item) : Call <String>

    @DELETE("item/{id}")
    @Headers("Accept: application/json;charset=utf-8")
    fun deleteItem (@Path("id") id :String ) : Call<Unit>


    @GET("/item/all/{keyword}")
    @Headers("Accept: application/json;charset=utf-8")
    fun getItemsbyName(@Path("keyword") keyword :String) : Call<List<Item>>






}