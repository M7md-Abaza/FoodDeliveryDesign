package com.m7mdabaza.fooddelivery.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.m7mdabaza.fooddelivery.R
import com.m7mdabaza.fooddelivery.onBoarding.activities.OnBoardingActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login.setOnClickListener {
            val intent = Intent(this@LoginActivity, OnBoardingActivity::class.java)
            startActivity(intent)
        }

    }
}