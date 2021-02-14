package com.parternship.locally.entity

import androidx.annotation.NonNull
import androidx.room.Entity

@Entity
class Subscription(@NonNull val id: String, var name: String, var items: Array<Pair<Item,Int>>, var freq : Int, var nextPay : Int  ){


    fun getPrice() : Int{
        var result : Int = 0

        for (item in items ){
            result += item.first.price * item.second
        }
        return result
    }



}