package com.main.app.fragments.practicemode

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.main.app.R


class PracticeModeFragment1 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_practice_mode1, container, false)

        val next = view.findViewById<Button>(R.id.btn_next_pm)
        next.setOnClickListener(View.OnClickListener {
            val fm = fragmentManager?.beginTransaction()
            fm?.replace(R.id.practice_mode_containerview, PracticeModeFragment2())?.commit()
        })
        return view
    }

}