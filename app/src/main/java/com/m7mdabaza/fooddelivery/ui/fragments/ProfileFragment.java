package com.m7mdabaza.fooddelivery.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.m7mdabaza.fooddelivery.R;
import com.m7mdabaza.fooddelivery.ui.activities.RestaurantActivity;
import com.m7mdabaza.fooddelivery.ui.adapters.ProfileRecyclerAdapter;
import com.m7mdabaza.fooddelivery.ui.adapters.RestaurantRecyclerAdapter;
import com.m7mdabaza.fooddelivery.ui.models.ProfileModel;
import com.m7mdabaza.fooddelivery.ui.models.RestaurantModel;

import java.util.ArrayList;


public class ProfileFragment extends Fragment {

    RecyclerView profileInfoRecycler;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        profileInfoRecycler = view.findViewById(R.id.profileInfoRecycler);

        profileInfoRecycler.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        ProfileRecyclerAdapter profileRecyclerAdapter = new ProfileRecyclerAdapter();
        profileRecyclerAdapter.setList(getProfileInfoList());
        profileInfoRecycler.setAdapter(profileRecyclerAdapter);

        return view;
    }


    private ArrayList getProfileInfoList() {
        ArrayList<ProfileModel> profileInfoList = new ArrayList<>();

        profileInfoList.add(new ProfileModel("My orders"));
        profileInfoList.add(new ProfileModel("My payment cards"));
        profileInfoList.add(new ProfileModel("My addresses"));
        profileInfoList.add(new ProfileModel("Promocodes"));
        profileInfoList.add(new ProfileModel("Share promocodes"));
        profileInfoList.add(new ProfileModel("FAQ"));
        profileInfoList.add(new ProfileModel("Exit"));

        return profileInfoList;
    }
}