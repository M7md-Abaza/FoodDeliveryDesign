package com.m7mdabaza.fooddelivery.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.m7mdabaza.fooddelivery.R
import com.m7mdabaza.fooddelivery.models.ProfileModel
import com.m7mdabaza.fooddelivery.ui.activities.HomeActivity
import java.util.*

class ProfileRecyclerAdapter : RecyclerView.Adapter<ProfileRecyclerAdapter.ProfileViewHolder>() {

    private var profileModelList = ArrayList<ProfileModel>()
    private lateinit var mContext: HomeActivity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.profile_recycler_item, parent, false)
        return ProfileViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val profileModel = profileModelList[position]
        holder.profileInfo.text = profileModel.profileInfo

    }

    override fun getItemCount(): Int {
        return profileModelList.size
    }

    class ProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var profileInfo = itemView.findViewById(R.id.profileInfo_item) as TextView
    }

    fun setList(ProfileModel: ArrayList<ProfileModel>, mContext: HomeActivity) {
        this.profileModelList = ProfileModel
        this.mContext = mContext
    }
}