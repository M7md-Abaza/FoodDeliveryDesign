package com.m7mdabaza.fooddelivery.onBoarding.adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.m7mdabaza.fooddelivery.onBoarding.fragments.FirstFragment
import com.m7mdabaza.fooddelivery.onBoarding.fragments.SecondFragment
import com.m7mdabaza.fooddelivery.onBoarding.fragments.ThirdFragment


class FragmentAdapter(activity: AppCompatActivity, private val itemsCount: Int) :
    FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return itemsCount
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                FirstFragment()
            }
            1 -> {
                SecondFragment()
            }
            else -> {
                ThirdFragment()
            }
        }
    }


}