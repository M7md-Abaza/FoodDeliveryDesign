package com.m7mdabaza.fooddelivery.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.m7mdabaza.fooddelivery.R;
import com.m7mdabaza.fooddelivery.ui.adapters.PopularFoodAdapter;
import com.m7mdabaza.fooddelivery.ui.adapters.RestaurantRecyclerAdapter;
import com.m7mdabaza.fooddelivery.ui.models.PopularModel;
import com.m7mdabaza.fooddelivery.ui.models.RestaurantModel;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class RestaurantActivity extends AppCompatActivity {

    ImageView back;
    RecyclerView restaurantRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        findViewById();

        restaurantRecycler.setLayoutManager(new LinearLayoutManager(RestaurantActivity.this, RecyclerView.VERTICAL, false));
        RestaurantRecyclerAdapter restaurantRecyclerAdapter = new RestaurantRecyclerAdapter();
        restaurantRecyclerAdapter.setList(getRestaurantFoodList(), RestaurantActivity.this);
        restaurantRecycler.setAdapter(restaurantRecyclerAdapter);


        back.setOnClickListener(view -> {
            super.onBackPressed();
        });


    }

    void findViewById() {
        back = findViewById(R.id.back_btn);
        restaurantRecycler = findViewById(R.id.restaurantRecycler);

    }

    private ArrayList getRestaurantFoodList() {
        ArrayList<RestaurantModel> restaurantFoodList = new ArrayList<>();

        restaurantFoodList.add(new RestaurantModel(R.drawable.dish_one, "CITRONELLE", "French",
                "40 - 60 mim", "15 - 20 USD", 4.7));
        restaurantFoodList.add(new RestaurantModel(R.drawable.dish_two, "VERO VERO", "French",
                "25 - 40 mim", "6 - 12 USD", 4.2));
        restaurantFoodList.add(new RestaurantModel(R.drawable.dish_three, "MILK BAR", "French",
                "10 - 20 mim", "3 - 9 USD", 3.8));
        restaurantFoodList.add(new RestaurantModel(R.drawable.dish_four, "CITRONELLE", "French",
                "25 - 35 mim", "9 - 16 USD", 5.0));
        restaurantFoodList.add(new RestaurantModel(R.drawable.dish_five, "VERO VERO", "French",
                "35 - 50 mim", "15 - 20 USD", 4.7));
        restaurantFoodList.add(new RestaurantModel(R.drawable.dish_six, "MILK BAR", "French",
                "32 - 45 mim", "10 - 18 USD", 4.0));
        return restaurantFoodList;
    }
}