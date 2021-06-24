package com.m7mdabaza.fooddelivery.ui.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.m7mdabaza.fooddelivery.R
import com.m7mdabaza.fooddelivery.ui.fragments.*

import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener)
        openFragment(HomeFragment())
        if (null == savedInstanceState) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, HomeFragment()).commit()
        }

    }

    private var navigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.navigation_home -> openFragment(HomeFragment())
                R.id.navigation_favourite -> openFragment(FavouriteFragment())
                R.id.navigation_cart -> openFragment(CartFragment())
                R.id.navigation_profile -> openFragment(ProfileFragment())
            }
            true
        }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}