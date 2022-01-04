package com.main.app.fragments.practicemode

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.main.app.R
import com.main.app.practice.Position

class InstructionFragment : Fragment() {

    lateinit  var startGameBtn : TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_instruction, container, false)

        startGameBtn = view.findViewById(R.id.startGameBtn)

//        var duration = 20
//        startGameBtn.text = "Game Starts in "+ duration
        object : CountDownTimer(30000,1000) {
            //30000 = 30second

            override fun onTick(millisUntilFinished: Long) {
//                duration = (millisUntilFinished/1000).toInt()
                startGameBtn.text = "Game Starts in " + millisUntilFinished / 1000 + " sec"
            }

            override fun onFinish() {
                val intent = Intent(activity, Position::class.java)
                startActivity(intent)
                activity?.finish()
            }
        }.start()

        startGameBtn.setOnClickListener {
            val intent = Intent(activity, Position::class.java)
            startActivity(intent)
            activity?.finish()
        }

        return view
    }




    }
