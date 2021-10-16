package com.main.app

import android.app.ActionBar
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.main.app.fragments.FragmentLoading
import com.main.app.fragments.SplashFragment
import com.main.app.splashscreen.LoginActivity
import com.main.app.utils.FragmentCommunicator
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity(), FragmentCommunicator {


    private val splashFragment = SplashFragment()
    private val loadingFragment = FragmentLoading()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val introManager: IntroManager = IntroManager(this)
//
////        not opening application for first time
//        if (introManager.checkFirst()!=true) {
//            introManager.setFirst(false)
//            val intent : Intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//            finish()
//
//        }

        setContentView(R.layout.activity_main)

        val transactionsplash = supportFragmentManager.beginTransaction()
        transactionsplash.replace(R.id.fragment_containermain, splashFragment).commit()

        //      show loading screen

        Handler(Looper.getMainLooper()).postDelayed(
            {
                this.gotoLoadingFragment()
                gotoLoadingFragment()
            },
            1000 // value in milliseconds
        )
        }



    override fun gotoLoadingFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_containermain, loadingFragment)
            .commit()
    }

    override fun gotoStartGameFragment(name: String) {
    }


}


