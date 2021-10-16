package com.main.app.fragments

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.main.app.IntroManager
import com.main.app.R
import com.main.app.splashscreen.LoginActivity

class FragmentLoading : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_loading, container, false)

        Toast.makeText(this.context,"entered fragment Loading",Toast.LENGTH_LONG).show()
        return view


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // go to login and tutorials
        Handler(Looper.getMainLooper()).postDelayed(
            {
            val intent  = Intent(activity,LoginActivity::class.java)
                startActivity(intent)
                activity?.finish()
            },
            1000 // value in milliseconds
        )





    }


}