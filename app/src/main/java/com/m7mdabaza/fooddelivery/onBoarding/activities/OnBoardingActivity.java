package com.m7mdabaza.fooddelivery.onBoarding.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.Context;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.m7mdabaza.fooddelivery.R;
import com.m7mdabaza.fooddelivery.onBoarding.FragmentAdapter;
import com.m7mdabaza.fooddelivery.ui.activities.HomeActivity;

public class OnBoardingActivity extends AppCompatActivity {

    String prevStarted = "prevStarted";

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedpreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        if (!sharedpreferences.getBoolean(prevStarted, false)) {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(prevStarted, Boolean.TRUE);
            editor.apply();
        } else {
            //finish();
            Intent intent = new Intent(OnBoardingActivity.this, HomeActivity.class);
            startActivity(intent);
        }
    }

    TextView getStarted;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        viewPager = findViewById(R.id.viewpager);
        getStarted = findViewById(R.id.getStarted);
        tabLayout = findViewById(R.id.tabDots);

        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fragmentAdapter);

        tabLayout.setupWithViewPager(viewPager, true);

        getStarted.setOnClickListener(view -> {
            Intent intent = new Intent(OnBoardingActivity.this, HomeActivity.class);
            startActivity(intent);
        });

    }
}