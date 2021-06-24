package com.m7mdabaza.fooddelivery.adapters

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.m7mdabaza.fooddelivery.R
import com.m7mdabaza.fooddelivery.ui.activities.FoodPreviewActivity
import com.m7mdabaza.fooddelivery.ui.activities.RestaurantActivity
import com.m7mdabaza.fooddelivery.adapters.RestaurantRecyclerAdapter.RestaurantViewHolder
import com.m7mdabaza.fooddelivery.models.RestaurantModel
import java.util.*

class RestaurantRecyclerAdapter : RecyclerView.Adapter<RestaurantViewHolder>() {


    private var restaurantModelList = ArrayList<RestaurantModel>()
    private lateinit var mContext: RestaurantActivity


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.restaurant_item, parent, false)
        return RestaurantViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {

        val restaurantModel = restaurantModelList[position]
        holder.foodName.text = restaurantModel.foodName
        holder.foodCountry.text = restaurantModel.foodCountry
        holder.foodTime.text = restaurantModel.foodTime
        holder.foodPrice.text = restaurantModel.foodPrice
        holder.foodRate.text = restaurantModel.foodRate.toString() + ""


        holder.itemView.setOnClickListener {
            val intent = Intent(mContext, FoodPreviewActivity::class.java)
            intent.putExtra("foodName", restaurantModel.foodName)
            intent.putExtra("foodPrice", restaurantModel.foodPrice)
            intent.putExtra("foodRate", restaurantModel.foodRate.toString() + "")
            mContext.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return restaurantModelList.size
    }

    class RestaurantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //var imageUrl: ImageView = itemView.findViewById(R.id.restaurantImage_item)
        var foodName: TextView = itemView.findViewById(R.id.restaurantFoodName_item)
        var foodCountry: TextView = itemView.findViewById(R.id.restaurantFoodCountry_item)
        var foodTime: TextView = itemView.findViewById(R.id.restaurantFoodTime_item)
        var foodPrice: TextView = itemView.findViewById(R.id.restaurantFoodPrice_item)
        var foodRate: TextView = itemView.findViewById(R.id.restaurantFoodRate_item)

    }

    fun setList(RestaurantModelList: ArrayList<RestaurantModel>, mContext: RestaurantActivity) {
        this.restaurantModelList = RestaurantModelList
        this.mContext = mContext
    }
}