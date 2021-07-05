package com.m7mdabaza.fooddelivery.roomDatabase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FoodDao {
    // to insert stories to Room database
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFood(food: Food)

    //to get stories from Room dataBase
    @Query("select * from food_table order by id asc")
    fun getFood(): LiveData<List<Food>>

    //@Update
    @Query("update food_table set isFavourite=:isFav where id =:mId ")
    suspend fun addToFavorite(mId: Long?, isFav: Boolean)


    @Query("select * from food_table where isFavourite =:isFavorite order by id asc")
    fun getFavorite(isFavorite: Boolean): LiveData<List<Food>>

}