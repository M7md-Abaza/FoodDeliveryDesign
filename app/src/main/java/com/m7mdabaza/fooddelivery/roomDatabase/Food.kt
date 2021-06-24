package com.m7mdabaza.fooddelivery.roomDatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food_table")
data class Food(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    var foodName: String,
    var foodDescription: String,
    var foodCountry: String,
    var foodTime: String,
    var foodPrice: String,
    var foodRate: String
)
