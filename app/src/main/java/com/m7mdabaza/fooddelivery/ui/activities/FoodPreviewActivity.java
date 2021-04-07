package com.m7mdabaza.fooddelivery.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.m7mdabaza.fooddelivery.R;

public class FoodPreviewActivity extends AppCompatActivity {

    TextView foodName, foodPrice, foodRate, addToCart;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_preview);

        findViewById();
        receiveIntentData();

        addToCart.setOnClickListener(view -> {
            Toast.makeText(FoodPreviewActivity.this, "Food Added Successfully", Toast.LENGTH_LONG).show();
            super.onBackPressed();
        });

        back.setOnClickListener(view -> {
            super.onBackPressed();
        });
    }

    private void receiveIntentData() {
        if (getIntent().hasExtra("foodName") && getIntent().hasExtra("foodPrice") && getIntent().hasExtra("foodRate")) {
            String mFoodName = getIntent().getStringExtra("foodName");
            foodName.setText(mFoodName);
            String mFoodPrice = getIntent().getStringExtra("foodPrice");
            foodPrice.setText(mFoodPrice);
            String mFoodRate = getIntent().getStringExtra("foodRate");
            foodRate.setText(mFoodRate);

        }
    }

    void findViewById() {

        foodName = findViewById(R.id.foodPreviewName);
        foodPrice = findViewById(R.id.foodPreviewPrice);
        foodRate = findViewById(R.id.foodPreviewRate);
        addToCart = findViewById(R.id.foodPreviewAddToCart);
        back = findViewById(R.id.back_btn);
    }
}