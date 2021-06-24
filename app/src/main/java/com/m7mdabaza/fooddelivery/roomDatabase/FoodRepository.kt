package com.m7mdabaza.fooddelivery.roomDatabase

import androidx.lifecycle.LiveData

class FoodRepository(private val foodDao: FoodDao) {

    val getFood: LiveData<List<Food>> = foodDao.getFood()

    suspend fun insertFood(food: Food){
        foodDao.insertFood(food)
    }

}