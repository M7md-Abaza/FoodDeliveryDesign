package com.m7mdabaza.fooddelivery.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.m7mdabaza.fooddelivery.R
import com.m7mdabaza.fooddelivery.models.PopularModel
import java.util.*

class PopularFoodAdapter : RecyclerView.Adapter<PopularFoodAdapter.PopularFoodViewHolder>() {

    private var popularModel = ArrayList<PopularModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularFoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.popular_food_item, parent, false)
        return PopularFoodViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PopularFoodViewHolder, position: Int) {
        val popularModel = popularModel[position]
        holder.foodName.text = popularModel.foodName
        holder.foodDescription.text = popularModel.foodDescription
        holder.foodRate.text = popularModel.rate.toString() + ""
    }

    override fun getItemCount(): Int {
        return popularModel.size
    }

     class PopularFoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       // var imageUrl: ImageView = itemView.findViewById(R.id.foodImage)
         var foodName: TextView = itemView.findViewById(R.id.foodName_tv)
         var foodDescription: TextView = itemView.findViewById(R.id.foodDesc_tv)
         var foodRate: TextView = itemView.findViewById(R.id.rate_tv)

     }

    fun setList(PopularModel: ArrayList<PopularModel>) {
        this.popularModel = PopularModel
    }
}