package com.main.app.fragments.homeFragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.main.app.PracticeMode
import com.main.app.R

class HomeScreen : Fragment(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_screen, container, false)
        val practiceMode = view.findViewById<Button>(R.id.practice_mode)
        practiceMode.setOnClickListener(this)
        return view;
    }

    override fun onClick(v: View?) {
        if(v != null && v.id == R.id.practice_mode){
            val intent = Intent(activity, PracticeMode::class.java)
            startActivity(intent)
        }
    }
}