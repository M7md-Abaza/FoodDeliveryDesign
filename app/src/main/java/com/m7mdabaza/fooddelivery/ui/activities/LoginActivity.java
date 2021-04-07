package com.m7mdabaza.fooddelivery.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;

import com.m7mdabaza.fooddelivery.R;
import com.m7mdabaza.fooddelivery.onBoarding.activities.OnBoardingActivity;

public class LoginActivity extends AppCompatActivity {

    Button logIn_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logIn_btn = findViewById(R.id.logIn_btn);

        logIn_btn.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, OnBoardingActivity.class);
            startActivity(intent);
        });
    }
}