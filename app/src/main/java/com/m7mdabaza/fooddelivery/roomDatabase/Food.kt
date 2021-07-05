package com.m7mdabaza.fooddelivery.roomDatabase

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.m7mdabaza.fooddelivery.ui.fragments.FavouriteFragment

@Entity(tableName = "food_table")
data class Food(
    var foodName: String,
    var foodDescription: String,
    var foodCountry: String,
    var foodTime: String,
    var foodPrice: String,
    var foodRate: String,
    var isFavourite : Boolean
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}
