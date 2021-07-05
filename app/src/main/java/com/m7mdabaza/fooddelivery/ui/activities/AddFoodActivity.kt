package com.m7mdabaza.fooddelivery.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.m7mdabaza.fooddelivery.R
import com.m7mdabaza.fooddelivery.roomDatabase.Food
import com.m7mdabaza.fooddelivery.roomDatabase.FoodViewModel

import kotlinx.android.synthetic.main.activity_add_food.*

class AddFoodActivity : AppCompatActivity() {

    private lateinit var mFoodViewModel: FoodViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food)

        mFoodViewModel = ViewModelProvider(this).get(FoodViewModel(application)::class.java)

        addFoodButton.setOnClickListener {
            insertFood()
        }

    }

    private fun insertFood() {
        val foodName = foodName.text.toString().trim()
        val foodDescription = foodDescription.text.toString().trim()
        val foodCountry = foodCountry.text.toString().trim()
        val foodTime = foodTime.text.toString().trim()
        val foodPrice = foodPrice.text.toString().trim()
        val foodRate = foodRate.text.toString().trim()

        if (inputCheck(foodName, foodDescription, foodCountry, foodTime, foodPrice, foodRate)) {

            val food =
                Food(foodName, foodDescription, foodCountry, foodTime, foodPrice, foodRate, false)
            mFoodViewModel.insertFood(food)

            Toast.makeText(this, "Successfully added!", Toast.LENGTH_LONG).show()
            onBackPressed()

        } else {
            Toast.makeText(this, "Please fill out all fields.", Toast.LENGTH_LONG).show()

        }

    }

    private fun inputCheck(
        foodName: String, foodDescription: String, foodCountry: String,
        foodTime: String, foodPrice: String, foodRate: String
    ): Boolean {
        return !(TextUtils.isEmpty(foodName) && TextUtils.isEmpty(foodDescription)
                && TextUtils.isEmpty(foodCountry) && TextUtils.isEmpty(foodTime)
                && TextUtils.isEmpty(foodPrice) && TextUtils.isEmpty(foodRate))
    }

}