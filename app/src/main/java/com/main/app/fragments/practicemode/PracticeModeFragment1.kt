package com.main.app.fragments.practicemode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.flatdialoglibrary.dialog.FlatDialog
import com.google.android.material.button.MaterialButton
import com.main.app.R
import com.main.app.practice.PracticeModeActivity
import com.main.app.utils.FragmentCommunicator


class PracticeModeFragment1 : Fragment() {

    lateinit var createGameBtn : MaterialButton

    //info btns
    lateinit var infoBtnPortfolio : ImageButton
    lateinit var infoBtnMarketPlace : ImageButton
    lateinit var infoBtnTimeFrame : ImageButton
    lateinit var infoBtnGamePlay : ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_practice_mode1, container, false)
        createGameBtn = view.findViewById(R.id.createGameBtn)

        infoBtnPortfolio = view.findViewById(R.id.infoBtnPortfolio)
        infoBtnTimeFrame = view.findViewById(R.id.infoBtnTimeFrame)
        infoBtnGamePlay = view.findViewById(R.id.infoBtnGameType)

//        val alertDialog  = AlertDialog.Builder(this)
        infoBtnGamePlay.setOnClickListener {
            val msg = "CLicked on Info Btn Game Play"
            val title = "READ ME"

            showMsg(title,msg)

        }

        createGameBtn.setOnClickListener {
            val fragmentCommunicator = activity as FragmentCommunicator
            fragmentCommunicator.gotoInstructionFragment()
        }

        return view
    }

    fun showMsg(title: String,msg : String){
       val flatDialog = FlatDialog(PracticeModeActivity())
        flatDialog.setTitle(title)
            .setSubtitle(msg)
            .show()
    }


}