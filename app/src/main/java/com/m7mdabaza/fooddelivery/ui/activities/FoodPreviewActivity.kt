package com.m7mdabaza.fooddelivery.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.m7mdabaza.fooddelivery.R
import kotlinx.android.synthetic.main.activity_food_preview.*

class FoodPreviewActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_preview)

        receiveIntentData()

        foodPreviewAddToCart.setOnClickListener {
            Toast.makeText(this@FoodPreviewActivity, "Food Added Successfully", Toast.LENGTH_LONG).show()
            super.onBackPressed()
        }

        backButton.setOnClickListener { super.onBackPressed() }

    }

    private fun receiveIntentData() {
        if (intent.hasExtra("foodName") && intent.hasExtra("foodPrice") && intent.hasExtra("foodRate")) {
            val mFoodName = intent.getStringExtra("foodName")
            foodPreviewName.text = mFoodName
            val mFoodPrice = intent.getStringExtra("foodPrice")
            foodPreviewPrice.text = mFoodPrice
            val mFoodRate = intent.getStringExtra("foodRate")
            foodPreviewRate.text = mFoodRate
        }
    }

}