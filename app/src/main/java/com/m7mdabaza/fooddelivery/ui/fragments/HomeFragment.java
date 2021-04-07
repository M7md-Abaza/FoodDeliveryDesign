package com.m7mdabaza.fooddelivery.ui.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.m7mdabaza.fooddelivery.R;
import com.m7mdabaza.fooddelivery.ui.adapters.PopularFoodAdapter;
import com.m7mdabaza.fooddelivery.ui.models.PopularModel;
import com.m7mdabaza.fooddelivery.ui.activities.RestaurantActivity;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private ImageView foodImage;
    private TextView foodName, foodDesc, foodRate;
    private RecyclerView popularRecycler, specialOfferRecycler;
    private LinearLayout restaurantCard;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        restaurantCard = view.findViewById(R.id.restaurantCard);
        popularRecycler = view.findViewById(R.id.popularFoodRecycler);

        popularRecycler.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        PopularFoodAdapter popularFoodAdapter = new PopularFoodAdapter();
        popularFoodAdapter.setList(getData());
        popularRecycler.setAdapter(popularFoodAdapter);

        specialOfferRecycler = view.findViewById(R.id.specialOffersRecycler);
        specialOfferRecycler.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        specialOfferRecycler.setAdapter(popularFoodAdapter);


        restaurantCard.setOnClickListener(view1 -> {
            Intent intent = new Intent(getContext(), RestaurantActivity.class);
            getContext().startActivity(intent);
        });


        // Inflate the layout for this fragment
        return view;
    }

    private ArrayList getData() {
        ArrayList<PopularModel> dataList = new ArrayList<>();

        dataList.add(new PopularModel(R.drawable.dish_one, "Potato - Eggs",
                "Potato - Egg for breakfast give you power, Potato - Egg for breakfast give you power",
                4.5));
        dataList.add(new PopularModel(R.drawable.dish_two, "Potato - Eggs",
                "Potato - Egg for breakfast give you power, Potato - Egg for breakfast give you power",
                3.9));
        dataList.add(new PopularModel(R.drawable.dish_three, "Potato - Eggs",
                "Potato - Egg for breakfast give you power, Potato - Egg for breakfast give you power",
                3.3));
        dataList.add(new PopularModel(R.drawable.dish_four, "Potato - Eggs",
                "Potato - Egg for breakfast give you power, Potato - Egg for breakfast give you power",
                3.7));
        dataList.add(new PopularModel(R.drawable.dish_five, "Potato - Eggs",
                "Potato - Egg for breakfast give you power, Potato - Egg for breakfast give you power",
                5.0));
        dataList.add(new PopularModel(R.drawable.dish_six, "Potato - Eggs",
                "Potato - Egg for breakfast give you power, Potato - Egg for breakfast give you power",
                4.0));
        return dataList;
    }
}