@file:Suppress("UNCHECKED_CAST")

package com.m7mdabaza.fooddelivery.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.m7mdabaza.fooddelivery.R
import com.m7mdabaza.fooddelivery.adapters.RestaurantRecyclerAdapter
import com.m7mdabaza.fooddelivery.models.RestaurantModel
import kotlinx.android.synthetic.main.activity_restaurant.*
import java.util.*

class RestaurantActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)


        restaurantRecycler.layoutManager = LinearLayoutManager(this@RestaurantActivity, RecyclerView.VERTICAL, false)
        val restaurantRecyclerAdapter = RestaurantRecyclerAdapter()
        restaurantRecyclerAdapter.setList(getRestaurantFoodList() as ArrayList<RestaurantModel>, this@RestaurantActivity)
        restaurantRecycler.adapter = restaurantRecyclerAdapter


        backButton.setOnClickListener { super.onBackPressed() }

    }


    private fun getRestaurantFoodList(): ArrayList<*> {
        val restaurantFoodList = ArrayList<RestaurantModel>()
        restaurantFoodList.add(RestaurantModel(R.drawable.dish_one.toByte(), "CITRONELLE", "French",
                "40 - 60 mim", "15 - 20 USD", 4.7))
        restaurantFoodList.add(RestaurantModel(R.drawable.dish_two.toByte(), "VERO VERO", "French",
                "25 - 40 mim", "6 - 12 USD", 4.2))
        restaurantFoodList.add(RestaurantModel(R.drawable.dish_three.toByte(), "MILK BAR", "French",
                "10 - 20 mim", "3 - 9 USD", 3.8))
        restaurantFoodList.add(RestaurantModel(R.drawable.dish_four.toByte(), "CITRONELLE", "French",
                "25 - 35 mim", "9 - 16 USD", 5.0))
        restaurantFoodList.add(RestaurantModel(R.drawable.dish_five.toByte(), "VERO VERO", "French",
                "35 - 50 mim", "15 - 20 USD", 4.7))
        restaurantFoodList.add(RestaurantModel(R.drawable.dish_six.toByte(), "MILK BAR", "French",
                "32 - 45 mim", "10 - 18 USD", 4.0))
        return restaurantFoodList
    }

}