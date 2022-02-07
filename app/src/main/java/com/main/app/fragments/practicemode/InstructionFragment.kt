package com.main.app.fragments.practicemode

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.main.app.R
import com.main.app.practice.PMGameActivity

class InstructionFragment : Fragment() {

    lateinit  var startGameBtn : TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_instruction, container, false)
        startGameBtn = view.findViewById(R.id.startGameBtn)
        val bundle = arguments
       val duration = bundle?.getString("time")
//        startGameBtn.text = "Game Starts in "+ duration
        val countDownTimer = object : CountDownTimer(30000,1000) {

            override fun onTick(millisUntilFinished: Long) {
                startGameBtn.text = "Game Starts in " + millisUntilFinished / 1000 + " sec"

            }

            override fun onFinish() {
                val intent = Intent(activity, PMGameActivity::class.java)
                intent.putExtra("time",duration.toString())
                startActivity(intent)
                activity?.finish()
            }
        }
        countDownTimer.start()

        startGameBtn.setOnClickListener {
            val intent = Intent(activity, PMGameActivity::class.java)
            startActivity(intent)
            countDownTimer.cancel()
            activity?.finish()
        }

        return view
    }




    }
