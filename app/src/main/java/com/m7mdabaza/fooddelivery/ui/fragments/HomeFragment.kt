package com.m7mdabaza.fooddelivery.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.m7mdabaza.fooddelivery.R
import com.m7mdabaza.fooddelivery.ui.activities.RestaurantActivity
import com.m7mdabaza.fooddelivery.adapters.PopularFoodAdapter
import com.m7mdabaza.fooddelivery.models.PopularModel
import com.m7mdabaza.fooddelivery.ui.activities.AddFoodActivity
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.util.*

@Suppress("UNCHECKED_CAST")
class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)


        view.popularFoodRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val popularFoodAdapter = PopularFoodAdapter()
        popularFoodAdapter.setList(getData())
        view.popularFoodRecycler.adapter = popularFoodAdapter

        view.specialOffersRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        view.specialOffersRecycler.adapter = popularFoodAdapter

        view.restaurantCard.setOnClickListener {
            val intent = Intent(context, RestaurantActivity::class.java)
            requireContext().startActivity(intent)
        }

        view.moreOptions.setOnClickListener {
            val intent = Intent(context, AddFoodActivity::class.java)
            requireContext().startActivity(intent)
        }

        // Inflate the layout for this fragment
        return view
    }


    private fun getData(): ArrayList<PopularModel> {
        val dataList = ArrayList<PopularModel>()
        dataList.add(
            PopularModel(
                R.drawable.dish_one, "Potato - Eggs",
                "Potato - Egg for breakfast give you power, Potato - Egg for breakfast give you power",
                4.5
            )
        )
        dataList.add(
            PopularModel(
                R.drawable.dish_two, "Potato - Eggs",
                "Potato - Egg for breakfast give you power, Potato - Egg for breakfast give you power",
                3.9
            )
        )
        dataList.add(
            PopularModel(
                R.drawable.dish_three, "Potato - Eggs",
                "Potato - Egg for breakfast give you power, Potato - Egg for breakfast give you power",
                3.3
            )
        )
        dataList.add(
            PopularModel(
                R.drawable.dish_four, "Potato - Eggs",
                "Potato - Egg for breakfast give you power, Potato - Egg for breakfast give you power",
                3.7
            )
        )
        dataList.add(
            PopularModel(
                R.drawable.dish_five, "Potato - Eggs",
                "Potato - Egg for breakfast give you power, Potato - Egg for breakfast give you power",
                5.0
            )
        )
        dataList.add(
            PopularModel(
                R.drawable.dish_six, "Potato - Eggs",
                "Potato - Egg for breakfast give you power, Potato - Egg for breakfast give you power",
                4.0
            )
        )
        return dataList
    }
}