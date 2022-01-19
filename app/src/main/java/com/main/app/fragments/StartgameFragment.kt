package com.main.app.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.main.app.Home
import com.main.app.R
import pl.droidsonroids.gif.GifImageButton


class StartgameFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_startgame, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val playBtn = view.findViewById<GifImageButton>(R.id.playBtn)
        playBtn.setOnClickListener {
            val intent = Intent(activity,Home::class.java)
            startActivity(intent)
            activity?.finish()
        }
    }

}