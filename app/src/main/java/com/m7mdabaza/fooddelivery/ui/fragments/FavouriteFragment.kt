package com.m7mdabaza.fooddelivery.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.m7mdabaza.fooddelivery.R
import com.m7mdabaza.fooddelivery.adapters.FavoriteAdapter
import com.m7mdabaza.fooddelivery.roomDatabase.Food
import com.m7mdabaza.fooddelivery.roomDatabase.FoodViewModel
import com.m7mdabaza.fooddelivery.ui.activities.HomeActivity
import kotlinx.android.synthetic.main.fragment_favourite.view.*
import java.util.ArrayList

class FavouriteFragment : Fragment() {

    private lateinit var mFoodViewModel: FoodViewModel
    private val favoriteAdapter = FavoriteAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_favourite, container, false)
        view.favoriteRecycler.layoutManager = LinearLayoutManager(context)
        view.favoriteRecycler.adapter = favoriteAdapter

        getFavoriteFood()

        return view
    }


    private fun getFavoriteFood() {
        //FoodViewModel
        mFoodViewModel =
            ViewModelProvider(this).get(FoodViewModel(activity!!.application)::class.java)
        mFoodViewModel.getFavorite.observe(viewLifecycleOwner, { food ->
            favoriteAdapter.setList(
                food as ArrayList<Food>,
                context as HomeActivity
            )
            favoriteAdapter.notifyDataSetChanged()
        })
    }
}