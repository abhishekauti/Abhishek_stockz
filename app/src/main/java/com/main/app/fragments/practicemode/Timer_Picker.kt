package com.main.app.fragments.practicemode

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.NumberPicker
import com.main.app.R
import com.main.app.utils.FragmentCommunicator
import kotlinx.android.synthetic.main.fragment_loading.view.*
import kotlinx.android.synthetic.main.fragment_timer__picker.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Timer_Picker.newInstance] factory method to
 * create an instance of this fragment.
 */
class Timer_Picker : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_timer__picker, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        picker_hours.maxValue = 24
//        picker_minutes.maxValue = 60
//       picker_seconds.maxValue = 60
        picker_hours.maxValue = 24
        picker_minutes.maxValue = 59
        picker_seconds.maxValue = 59
        val startgamebtn = view.findViewById<Button>(R.id.start_button)
        startgamebtn?.setOnClickListener {
            startgame()
        }
    }
    private fun startgame() {

      val hh = picker_hours.value.toString()
        val mm = picker_minutes.value.toString()
       val ss = picker_seconds.value.toString()
       val time :String = hh +":" +mm+":" + ss
       val fragmentCommunicator = activity as FragmentCommunicator
        fragmentCommunicator.gotoInstructionFragment(time)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Timer_Picker.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Timer_Picker().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}