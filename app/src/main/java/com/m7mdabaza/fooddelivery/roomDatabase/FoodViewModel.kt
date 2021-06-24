package com.m7mdabaza.fooddelivery.roomDatabase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


public class FoodViewModel(application: Application) : AndroidViewModel(application) {

    private val getFood: LiveData<List<Food>>
    private val repository: FoodRepository

    //this is the first method executed when userViewModel is called
    init {
        val foodDao = FoodDatabase.getDatabaseInstance(application).foodDao()
        repository = FoodRepository(foodDao)
        getFood = repository.getFood
    }

    fun insertFood(food: Food) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertFood(food)
        }
    }
}