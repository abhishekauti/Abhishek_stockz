package com.main.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.main.app.adapters.userListAdapter
import com.main.app.databinding.ActivityLeaderBoardFragmentBinding
import com.main.app.databinding.ActivityMainBinding
import com.main.app.databinding.FragmentLeaderBoardScreenBinding

class leaderBoardFragment : AppCompatActivity() {

    private lateinit var binding: ActivityLeaderBoardFragmentBinding
    private lateinit var userArrayList: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeaderBoardFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
        binding.listView.adapter = userListAdapter(this , userArrayList)

    }
}