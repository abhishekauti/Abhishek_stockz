package com.main.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.fragment.app.Fragment
import com.main.app.databinding.ActivityLeaderboardBinding
import com.main.app.fragments.leaderboardFragment
import com.main.app.fragments.portfolioFragment

class Leaderboard : AppCompatActivity() {
    //lateinit var binding: ActivityLeaderboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityLeaderboardBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_leaderboard)

        val buttonClick=findViewById<Button>(R.id.leader)
        buttonClick.setOnClickListener {
            val Intent = Intent(this,leaderboardFragment::class.java)
            startActivity(Intent)
        }

//        binding.leader.setOnClickListener{
//            replaceFragment(leaderboardFragment())
//        }
//        binding.portfolio.setOnClickListener {
//            replaceFragment(portfolioFragment())
//        }

    }

    private  fun replaceFragment(fragment : Fragment){
        val fragmentManager= supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer,fragment)
        fragmentTransaction.commit()
    }
}