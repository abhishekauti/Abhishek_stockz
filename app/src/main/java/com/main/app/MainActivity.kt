package com.main.app

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.main.app.fragments.FragmentLoading
import com.main.app.fragments.SplashFragment

//Start

class MainActivity : AppCompatActivity() {


    private val splashFragment = SplashFragment()
    private val loadingFragment = FragmentLoading()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val transactionsplash = supportFragmentManager.beginTransaction()
        transactionsplash.replace(R.id.fragment_containermain, splashFragment).commit()

        //      show loading screen

            Handler(Looper.getMainLooper()).postDelayed(
                {
                    gotoLoadingFragment()
                },
                1000 // value in milliseconds
            )
        }



    fun gotoLoadingFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_containermain, loadingFragment)
            .commit()
    }




}


