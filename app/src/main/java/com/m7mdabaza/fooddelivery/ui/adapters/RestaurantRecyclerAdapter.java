package com.m7mdabaza.fooddelivery.ui.adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.m7mdabaza.fooddelivery.R;
import com.m7mdabaza.fooddelivery.ui.activities.FoodPreviewActivity;
import com.m7mdabaza.fooddelivery.ui.activities.RestaurantActivity;
import com.m7mdabaza.fooddelivery.ui.models.RestaurantModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RestaurantRecyclerAdapter extends RecyclerView.Adapter<RestaurantRecyclerAdapter.RestaurantViewHolder> {

    private ArrayList<RestaurantModel> RestaurantModelList = new ArrayList<>();
    private RestaurantActivity mContext;

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_item, parent, false);
        return new RestaurantViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
        RestaurantModel restaurantModel = RestaurantModelList.get(position);
        holder.foodName.setText(restaurantModel.getFoodName());
        holder.foodCountry.setText(restaurantModel.getFoodCountry());
        holder.foodTime.setText(restaurantModel.getFoodTime());
        holder.foodPrice.setText(restaurantModel.getFoodPrice());
        holder.foodRate.setText(restaurantModel.getFoodRate() + "");


        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(mContext, FoodPreviewActivity.class);
            intent.putExtra("foodName", restaurantModel.getFoodName());
            intent.putExtra("foodPrice", restaurantModel.getFoodPrice());
            intent.putExtra("foodRate", restaurantModel.getFoodRate() + "");

            mContext.startActivity(intent);
        });


    }

    @Override
    public int getItemCount() {
        return RestaurantModelList.size();
    }

    static class RestaurantViewHolder extends RecyclerView.ViewHolder {

        ImageView imageUrl;
        TextView foodName, foodCountry, foodTime, foodPrice, foodRate;

        RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);

            imageUrl = itemView.findViewById(R.id.restaurantImage_item);
            foodName = itemView.findViewById(R.id.restaurantFoodName_item);
            foodCountry = itemView.findViewById(R.id.restaurantFoodCountry_item);
            foodTime = itemView.findViewById(R.id.restaurantFoodTime_item);
            foodPrice = itemView.findViewById(R.id.restaurantFoodPrice_item);
            foodRate = itemView.findViewById(R.id.restaurantFoodRate_item);

        }

    }

    public void setList(ArrayList<RestaurantModel> RestaurantModelList, RestaurantActivity mContext) {
        this.RestaurantModelList = RestaurantModelList;
        this.mContext = mContext;
    }
}
