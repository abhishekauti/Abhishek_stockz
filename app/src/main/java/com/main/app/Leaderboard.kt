package com.main.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.main.app.databinding.ActivityLeaderboardBinding
import com.main.app.fragments.leaderboardFragment
import com.main.app.fragments.portfolioFragment

class Leaderboard : AppCompatActivity() {
    lateinit var binding: ActivityLeaderboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeaderboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.leader.setOnClickListener{
            replaceFragment(leaderboardFragment())
        }
        binding.portfolio.setOnClickListener {
            replaceFragment(portfolioFragment())
        }

    }

    private  fun replaceFragment(fragment : Fragment){
        val fragmentManager= supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer,fragment)
        fragmentTransaction.commit()
    }
}