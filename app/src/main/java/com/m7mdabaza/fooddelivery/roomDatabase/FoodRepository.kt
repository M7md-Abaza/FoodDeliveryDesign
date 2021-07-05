package com.m7mdabaza.fooddelivery.roomDatabase

import androidx.lifecycle.LiveData

class FoodRepository(private val foodDao: FoodDao) {

    val getFood: LiveData<List<Food>> = foodDao.getFood()
    val getFavorite: LiveData<List<Food>> = foodDao.getFavorite(true)

    suspend fun insertFood(food: Food){
        foodDao.insertFood(food)
    }

    suspend fun addToFavorite(mId: Long?, isFav: Boolean){
        foodDao.addToFavorite(mId,isFav)
    }
}