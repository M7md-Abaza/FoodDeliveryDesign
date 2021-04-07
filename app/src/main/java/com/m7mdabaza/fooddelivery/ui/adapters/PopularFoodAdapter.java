package com.m7mdabaza.fooddelivery.ui.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.m7mdabaza.fooddelivery.R;
import com.m7mdabaza.fooddelivery.ui.models.PopularModel;

import java.util.ArrayList;

public class PopularFoodAdapter extends RecyclerView.Adapter<PopularFoodAdapter.PopularFoodViewHolder> {

    private ArrayList<PopularModel> PopularModel = new ArrayList<>();


    @NonNull
    @Override
    public PopularFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_food_item, parent, false);
        return new PopularFoodViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PopularFoodViewHolder holder, int position) {
        PopularModel popularModel = PopularModel.get(position);
        holder.foodName.setText(popularModel.getFoodName());
        holder.foodDescription.setText(popularModel.getFoodDescription());
        holder.foodRate.setText(popularModel.getRate() + "");
    }

    @Override
    public int getItemCount() {
        return PopularModel.size();
    }

    static class PopularFoodViewHolder extends RecyclerView.ViewHolder {

        ImageView imageUrl;
        TextView foodName, foodDescription, foodRate;

        PopularFoodViewHolder(@NonNull View itemView) {
            super(itemView);

            imageUrl = itemView.findViewById(R.id.foodImage);
            foodName = itemView.findViewById(R.id.foodName_tv);
            foodDescription = itemView.findViewById(R.id.foodDesc_tv);
            foodRate = itemView.findViewById(R.id.rate_tv);

        }

    }

    public void setList(ArrayList<PopularModel> PopularModel) {
        this.PopularModel = PopularModel;

    }
}
