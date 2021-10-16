package com.main.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.main.app.fragments.homeFragments.HomeScreen
import com.main.app.fragments.homeFragments.LeaderBoardScreen
import com.main.app.fragments.homeFragments.PortfolioScreen
import com.main.app.fragments.homeFragments.SettingsScreen

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        val fragmentHomeScreen = HomeScreen()
        val fragmentLeaderBoardScreen = LeaderBoardScreen()
        val fragmentPortfolioScreen = PortfolioScreen()
        val fragmentSettingsScreen = SettingsScreen()

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container_home,fragmentHomeScreen).commit()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home_btn -> {
                    changeFragment(fragmentHomeScreen)
                    return@setOnItemSelectedListener true
                }
                R.id.portfolio_btn ->{
                    changeFragment(fragmentPortfolioScreen)
                    return@setOnItemSelectedListener true
                }
                R.id.leaderboard_btn -> {
                    changeFragment(fragmentLeaderBoardScreen)
                    return@setOnItemSelectedListener true
                }
                R.id.settings_btn -> {
                    changeFragment(fragmentSettingsScreen)
                    return@setOnItemSelectedListener true
                }
            }
            false
        }



    }

    private fun changeFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container_home,fragment)
            .commit()
    }
}