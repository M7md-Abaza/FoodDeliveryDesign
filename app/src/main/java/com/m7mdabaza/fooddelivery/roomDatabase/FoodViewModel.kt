package com.m7mdabaza.fooddelivery.roomDatabase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FoodViewModel(application: Application) : AndroidViewModel(application) {

    val getFood: LiveData<List<Food>>
    val getFavorite: LiveData<List<Food>>
    private val repository: FoodRepository

    //this is the first method executed when userViewModel is called
    init {
        val foodDao = FoodDatabase.getDatabaseInstance(application).foodDao()
        repository = FoodRepository(foodDao)
        getFood = repository.getFood
        getFavorite = repository.getFavorite
    }

    fun insertFood(food: Food) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertFood(food)
        }
    }

    fun addToFavorite(mId: Long?, isFav: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addToFavorite(mId, isFav)
        }
    }
}