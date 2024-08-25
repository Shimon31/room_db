package com.example.roomdb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.roomdb.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)


        val names = listOf(
            "John", "Alice", "Michael", "Emma", "David", "Sophia", "Daniel", "Olivia",
            "Matthew", "Isabella", "James", "Ava", "Benjamin", "Mia", "William", "Charlotte",
            "Alexander", "Amelia", "Henry", "Harper", "Joseph", "Evelyn", "Samuel", "Abigail",
            "Christopher", "Emily", "Andrew", "Madison", "Joshua", "Lily", "Ethan", "Ella",
            "Anthony", "Grace", "Thomas", "Chloe", "Nathan", "Zoey", "Ryan", "Hannah",
            "Elijah", "Victoria", "Mason", "Aria", "Jacob", "Layla", "Logan", "Sofia",
            "Jackson", "Scarlett"
        )


        return binding.root
    }


}