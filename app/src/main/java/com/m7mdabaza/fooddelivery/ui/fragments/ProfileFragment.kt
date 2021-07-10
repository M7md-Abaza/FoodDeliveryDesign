package com.m7mdabaza.fooddelivery.ui.fragments

import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.Task
import com.m7mdabaza.fooddelivery.R
import com.m7mdabaza.fooddelivery.adapters.ProfileRecyclerAdapter
import com.m7mdabaza.fooddelivery.models.ProfileModel
import com.m7mdabaza.fooddelivery.ui.activities.HomeActivity
import kotlinx.android.synthetic.main.fragment_profile.view.*
import java.util.*

@Suppress("UNCHECKED_CAST")
class ProfileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_profile, container, false)

        view.profileInfoRecycler.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        val profileRecyclerAdapter = ProfileRecyclerAdapter()
        profileRecyclerAdapter.setList(getProfileInfoList() as ArrayList<ProfileModel>, HomeActivity())
        view.profileInfoRecycler.adapter = profileRecyclerAdapter

        return view
    }


    private fun getProfileInfoList(): ArrayList<*> {
        val profileInfoList = ArrayList<ProfileModel>()
        profileInfoList.add(ProfileModel("orders"))
        profileInfoList.add(ProfileModel("Payment cards"))
        profileInfoList.add(ProfileModel("Location"))
        profileInfoList.add(ProfileModel("Promocodes"))
        profileInfoList.add(ProfileModel("Share promocodes"))
        profileInfoList.add(ProfileModel("FAQ"))
        profileInfoList.add(ProfileModel("Exit"))
        return profileInfoList
    }
}