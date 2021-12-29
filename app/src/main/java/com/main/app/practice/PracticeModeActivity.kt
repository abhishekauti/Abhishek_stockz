package com.main.app.practice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.main.app.R
import com.main.app.fragments.practicemode.InstructionFragment
import com.main.app.fragments.practicemode.PracticeModeFragment1
import com.main.app.utils.FragmentCommunicator

class PracticeModeActivity : AppCompatActivity(), FragmentCommunicator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice_mode)

        val practiceMode1 = PracticeModeFragment1()

        val fmanager = supportFragmentManager.beginTransaction()
        fmanager.replace(R.id.practice_mode_containerview,practiceMode1).commit()

    }




    override fun gotoInstructionFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.practice_mode_containerview,InstructionFragment())
            .commit()
    }



    override fun gotoStartGameFragment(name: String) {
    }


}