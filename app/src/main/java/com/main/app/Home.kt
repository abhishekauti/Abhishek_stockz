package com.main.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.main.app.dao.PaymentDao
import com.main.app.fragments.homeFragments.HomeScreen
import com.main.app.fragments.homeFragments.LeaderBoardScreen
import com.main.app.fragments.homeFragments.PortfolioScreen
import com.main.app.fragments.homeFragments.SettingsScreen
import com.main.app.models.Payment
import com.razorpay.PaymentResultListener

class Home : AppCompatActivity(),PaymentResultListener {
    private lateinit var dao: PaymentDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //hello
        setSupportActionBar(findViewById(R.id.my_toolbar))



        val fragmentHomeScreen = HomeScreen()
        val fragmentLeaderBoardScreen = LeaderBoardScreen()
        val fragmentPortfolioScreen = PortfolioScreen()
        val fragmentSettingsScreen = SettingsScreen()



        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container_home,fragmentHomeScreen).commit()

       //dao = MainDatabase.getDatabase(applicationContext).getPaymentDao()

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

    override fun onPaymentSuccess(p0: String?) {
        Log.d("Suraj","Payment Successful : "+p0)
//        dao.insert(Payment(p0.toString()))
//        Log.d("Suraj",dao.getAllPayments().toString())
        //Toast.makeText(this,, Toast.LENGTH_LONG).show()
    }
    override fun onPaymentError(p0: Int, p1: String?) {
        Log.d("Suraj","Payment Successful : "+p1)
        //Toast.makeText(this,"Payment UnSuccessful"+p1, Toast.LENGTH_LONG).show()
    }
}