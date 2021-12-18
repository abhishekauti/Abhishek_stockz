package com.main.app.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.main.app.R
import com.main.app.fragments.practicemode.PracticeModeFragment1
import com.main.app.fragments.practicemode.PracticeModeFragment2

class PracticeModeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice_mode)

        val practiceMode1 = PracticeModeFragment1()
        val practiceMode2 = PracticeModeFragment2()


        val fmanager = supportFragmentManager.beginTransaction()
        fmanager.replace(R.id.practice_mode_containerview,practiceMode1).commit()

    }

    private fun changeFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container_home,fragment)
            .commit()
    }
}