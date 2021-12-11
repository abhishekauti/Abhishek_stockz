package com.main.app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.main.app.databinding.ActivityHomeBinding.inflate
import com.main.app.databinding.FragmentLeaderBoardScreenBinding
import android.R

import android.R.string.no
import com.main.app.User
import com.main.app.adapters.userListAdapter


class leaderboardFragment :Fragment(com.main.app.R.layout.leaderboardfragment) {

    private lateinit var binding: FragmentLeaderBoardScreenBinding
    private lateinit var userArrayList: ArrayList<User>


    override fun onCreate(inflater: LayoutInflater, container: ViewGroup?,
                          savedInstanceState: Bundle?): View? {

        super.onCreate(savedInstanceState)
        val view = inflater.inflate(com.main.app.R.layout.leaderboardfragment, container, false)

        val cars: List<User>? = null // Obtenha sua lista de objetos aqui

        val listView : ListView = view.findViewById(com.main.app.R.id.list_item)

        val name= arrayOf(
            "Aaditi",
            "Nikita",
            "Aovi",
            "Varsha",
            "Suraj"

        )

        val status = arrayOf(
            "Winner",
            "Runner up",
            "best",
            "abcd",
            "dfgh"
        )
        val img= com.main.app.R.drawable.sample;
        userArrayList = ArrayList()
        for(i in name.indices){
            val user= User(name[i] , status[i] , img)
            userArrayList.add(user)
        }
        // val listAdapter: userListAdapter = userListAdapter(context,userArrayList)
        return view

    }
}