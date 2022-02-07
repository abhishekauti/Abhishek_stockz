package com.main.app.fragments.practicemode

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.flatdialoglibrary.dialog.FlatDialog
import com.google.android.material.button.MaterialButton
import com.main.app.R
import com.main.app.practice.PracticeModeActivity
import com.main.app.utils.FragmentCommunicator
import kotlinx.android.synthetic.main.fragment_loading.view.*


class PracticeModeFragment1 : Fragment() {

    lateinit var createGameBtn : MaterialButton

    //info btns
    lateinit var infoBtnPortfolio : ImageButton
    lateinit var infoBtnMarketPlace : ImageButton
    lateinit var infoBtnTimeFrame : ImageButton
    lateinit var infoBtnGamePlay : ImageButton
    lateinit var spinner : Spinner
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
        spinner = view.findViewById(R.id.spinner_gameplay_type)

//        spinner.setOnClickListener {
//            Log.e("error","wrong")
//        }
//        val alertDialog  = AlertDialog.Builder(this)
        infoBtnGamePlay.setOnClickListener {
            val msg = "CLicked on Info Btn Game Play"
            val title = "READ ME"

            showMsg(title,msg)

        }

        createGameBtn.setOnClickListener {

            val mode = spinner.selectedItem.toString()
            if(mode.toLowerCase().equals("classic"))
                Toast.makeText(activity,"Code for classic is not ready yet!!!",Toast.LENGTH_LONG).show()
            else {
               val fragmentCommunicator = activity as FragmentCommunicator
                fragmentCommunicator.gotoTimerPickerFragment()
            }
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