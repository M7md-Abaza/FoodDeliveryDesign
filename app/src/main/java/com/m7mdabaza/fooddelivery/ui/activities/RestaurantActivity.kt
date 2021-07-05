@file:Suppress("UNCHECKED_CAST")

package com.m7mdabaza.fooddelivery.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.m7mdabaza.fooddelivery.R
import com.m7mdabaza.fooddelivery.adapters.RestaurantRecyclerAdapter
import com.m7mdabaza.fooddelivery.roomDatabase.Food
import com.m7mdabaza.fooddelivery.roomDatabase.FoodViewModel
import kotlinx.android.synthetic.main.activity_restaurant.*
import java.util.*

class RestaurantActivity : AppCompatActivity() {

    private lateinit var mFoodViewModel: FoodViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)


        getRestaurantFoodList()

        backButton.setOnClickListener { super.onBackPressed() }

    }


    private fun getRestaurantFoodList() {
        restaurantRecycler.layoutManager = LinearLayoutManager(this@RestaurantActivity)
        val restaurantRecyclerAdapter = RestaurantRecyclerAdapter()
        restaurantRecycler.adapter = restaurantRecyclerAdapter

        //FoodViewModel
        mFoodViewModel = ViewModelProvider(this).get(FoodViewModel(application)::class.java)
        mFoodViewModel.getFood.observe(this, { food ->
            restaurantRecyclerAdapter.setList(food as ArrayList<Food>, this@RestaurantActivity)
        })
    }
}