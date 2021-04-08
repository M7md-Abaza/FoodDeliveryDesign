package com.m7mdabaza.fooddelivery.ui.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.m7mdabaza.fooddelivery.R;
import com.m7mdabaza.fooddelivery.ui.models.ProfileModel;

import java.util.ArrayList;

public class ProfileRecyclerAdapter extends RecyclerView.Adapter<ProfileRecyclerAdapter.ProfileViewHolder> {

    private ArrayList<ProfileModel> ProfileModelList = new ArrayList<>();


    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_recycler_item, parent, false);
        return new ProfileViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {

        ProfileModel profileModel = ProfileModelList.get(position);
        holder.profileInfo.setText(profileModel.getProfileInfo());
    }

    @Override
    public int getItemCount() {
        return ProfileModelList.size();
    }

    static class ProfileViewHolder extends RecyclerView.ViewHolder {

        TextView profileInfo;

        ProfileViewHolder(@NonNull View itemView) {
            super(itemView);
            profileInfo = itemView.findViewById(R.id.profileInfo_item);
        }

    }

    public void setList(ArrayList<ProfileModel> ProfileModel) {
        this.ProfileModelList = ProfileModel;
    }
}
