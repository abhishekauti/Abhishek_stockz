package com.main.app.splashscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.main.app.Home
import com.main.app.IntroManager
import com.main.app.R
import com.main.app.fragments.NicknameFragment
import com.main.app.fragments.StartgameFragment
import com.main.app.utils.FragmentCommunicator


class LoginActivity : AppCompatActivity(), FragmentCommunicator {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val introManager: IntroManager = IntroManager(this)

//        not opening application for first time
        if (introManager.checkFirst()!=true) {
            introManager.setFirst(false)
            val intent : Intent = Intent(this, Home::class.java)
            startActivity(intent)
            finish()

        }
        else {
            val nicknameFragment = NicknameFragment()
            setContentView(R.layout.activity_login)
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.loginactivity_fragmentcontainer, nicknameFragment)
            transaction.commit()
        }
    }

    override fun gotoStartGameFragment(name: String) {
        val bundle = Bundle()
        bundle.putString("username", name)
        val transction = supportFragmentManager.beginTransaction()
        val startgameFragment = StartgameFragment()
        startgameFragment.arguments = bundle
        transction.replace(R.id.loginactivity_fragmentcontainer, startgameFragment)
        transction.commit()

    }

    override fun gotoInstructionFragment() {
        TODO("Not yet implemented")
    }
}










