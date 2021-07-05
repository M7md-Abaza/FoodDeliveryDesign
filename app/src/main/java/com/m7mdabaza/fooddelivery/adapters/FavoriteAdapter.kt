package com.m7mdabaza.fooddelivery.adapters

import android.annotation.SuppressLint
import android.app.Application
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.m7mdabaza.fooddelivery.R
import com.m7mdabaza.fooddelivery.roomDatabase.Food
import com.m7mdabaza.fooddelivery.roomDatabase.FoodViewModel
import com.m7mdabaza.fooddelivery.ui.activities.FoodPreviewActivity
import com.m7mdabaza.fooddelivery.ui.activities.HomeActivity
import java.util.ArrayList


class FavoriteAdapter : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    private var restaurantModelList = ArrayList<Food>()
    private lateinit var mContext: HomeActivity
    private lateinit var mFoodViewModel: FoodViewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.restaurant_item, parent, false)

        mFoodViewModel = ViewModelProvider(mContext).get(FoodViewModel(Application())::class.java)

        return FavoriteViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val restaurantModel = restaurantModelList[position]
        holder.foodName.text = restaurantModel.foodName
        holder.foodCountry.text = restaurantModel.foodCountry
        holder.foodTime.text = restaurantModel.foodTime + " min"
        holder.foodPrice.text = restaurantModel.foodPrice + " USD"
        holder.foodRate.text = restaurantModel.foodRate + ""
        val id = restaurantModel.id

        var isFav: Boolean = restaurantModel.isFavourite

        if (isFav){
            holder.foodFavorite.setImageResource(R.drawable.red_hart)
        }

        holder.foodFavorite.setOnClickListener {
            if (!isFav) {
                mFoodViewModel.addToFavorite(id, true)
                isFav = true
                holder.foodFavorite.setImageResource(R.drawable.red_hart)
                Toast.makeText(mContext, "Add Successfully!!", Toast.LENGTH_LONG).show()

            } else if (isFav) {
                mFoodViewModel.addToFavorite(id, false)
                isFav = false
                holder.foodFavorite.setImageResource(R.drawable.white_hart)
                Toast.makeText(mContext, "Removed Successfully!!", Toast.LENGTH_LONG).show()

            }
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(mContext, FoodPreviewActivity::class.java)
            intent.putExtra("foodName", restaurantModel.foodName)
            intent.putExtra("foodPrice", restaurantModel.foodPrice)
            intent.putExtra("foodRate", restaurantModel.foodRate + "")
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return restaurantModelList.size
    }

    class FavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //var imageUrl: ImageView = itemView.findViewById(R.id.restaurantImage_item)
        var foodName: TextView = itemView.findViewById(R.id.restaurantFoodName_item)
        var foodCountry: TextView = itemView.findViewById(R.id.restaurantFoodCountry_item)
        var foodTime: TextView = itemView.findViewById(R.id.restaurantFoodTime_item)
        var foodPrice: TextView = itemView.findViewById(R.id.restaurantFoodPrice_item)
        var foodRate: TextView = itemView.findViewById(R.id.restaurantFoodRate_item)
        var foodFavorite: ImageView = itemView.findViewById(R.id.addFoodToFavorite_item)

    }

    fun setList(RestaurantModelList: ArrayList<Food>, mContext: HomeActivity) {
        this.restaurantModelList = RestaurantModelList
        this.mContext = mContext
        notifyDataSetChanged()
    }

}