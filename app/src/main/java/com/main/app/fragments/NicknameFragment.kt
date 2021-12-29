package com.main.app.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.main.app.R
import com.main.app.utils.FragmentCommunicator


class NicknameFragment : Fragment() {

    lateinit var nametv: EditText
    lateinit var enterBtn: Button
    lateinit var name: String
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_nickname, container, false)
        nametv = view.findViewById(R.id.name_tv)
        enterBtn = view.findViewById(R.id.name_btn)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val enterBtn = view.findViewById<Button>(R.id.name_btn)

        enterBtn.setOnClickListener {
            name = nametv.text.toString()
            if (name != "") {

                val communicator: FragmentCommunicator = activity as FragmentCommunicator
                communicator.gotoStartGameFragment(name)
            }
            else{
                Log.i("MESSAGE","ERRROR")
            }
        }

    }
}