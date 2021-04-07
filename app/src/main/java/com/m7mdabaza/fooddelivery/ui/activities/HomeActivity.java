package com.m7mdabaza.fooddelivery.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.m7mdabaza.fooddelivery.R;
import com.m7mdabaza.fooddelivery.ui.fragments.CartFragment;
import com.m7mdabaza.fooddelivery.ui.fragments.FavouriteFragment;
import com.m7mdabaza.fooddelivery.ui.fragments.HomeFragment;
import com.m7mdabaza.fooddelivery.ui.fragments.ProfileFragment;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findViewById();

        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(new HomeFragment());
        if (null == savedInstanceState) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new HomeFragment()).commit();
        }
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            item -> {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        openFragment(new HomeFragment());
                        break;
                    case R.id.navigation_favourite:
                        openFragment(new FavouriteFragment());
                        break;
                    case R.id.navigation_cart:
                        openFragment(new CartFragment());
                        break;
                    case R.id.navigation_profile:
                        openFragment(new ProfileFragment());
                        break;
                }

                return true;
            };


    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainerView, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    void findViewById() {
        //BottomNavigationView
        bottomNavigation = findViewById(R.id.bottom_navigation);

    }
}