package com.m7mdabaza.fooddelivery.roomDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FoodDao {
    // to insert stories to Room database
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFood(food: Food)


    //to get stories from Room dataBase
    @Query("select * from food_table order by id asc")
    fun getFood(): LiveData<List<Food>>
}