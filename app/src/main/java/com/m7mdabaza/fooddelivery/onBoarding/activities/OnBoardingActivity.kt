package com.m7mdabaza.fooddelivery.onBoarding.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.m7mdabaza.fooddelivery.R
import com.m7mdabaza.fooddelivery.onBoarding.adapters.FragmentAdapter
import com.m7mdabaza.fooddelivery.ui.activities.HomeActivity
import kotlinx.android.synthetic.main.activity_on_boarding.*
import androidx.viewpager2.widget.ViewPager2

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2

    private var prevStarted = "prevStarted"

    override fun onResume() {
        super.onResume()
        val sharedpreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE)
        if (!sharedpreferences.getBoolean(prevStarted, false)) {
            val editor = sharedpreferences.edit()
            editor.putBoolean(prevStarted, true)
            editor.apply()
        } else {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        val fragmentAdapter = FragmentAdapter(activity = this, 3)
        viewPager2 = findViewById(R.id.viewpager2)
        viewPager2.adapter = fragmentAdapter

        tabDots.setViewPager(viewPager2)
        //Optional
        fragmentAdapter.registerAdapterDataObserver(tabDots.adapterDataObserver)

        getStarted.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }

}