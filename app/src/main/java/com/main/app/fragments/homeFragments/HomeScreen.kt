package com.main.app.fragments.homeFragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.main.app.R
import com.main.app.practice.PracticeModeActivity

class HomeScreen : Fragment() {

    lateinit var practiceMode : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_screen, container, false)
        val pay = view.findViewById<Button>(R.id.payment)
        val paymentHistory = view.findViewById<Button>(R.id.btn_payment_history)
        practiceMode = view.findViewById(R.id.practice_mode)

        practiceMode.setOnClickListener{
            startPracticeModeActivity()
        }
//
//        pay.setOnClickListener(this)
//        paymentHistory.setOnClickListener(this)
        return view;
    }

    private fun startPracticeModeActivity() {
        val intent: Intent = Intent(activity,PracticeModeActivity::class.java)
        startActivity(intent)
        //TODO finish
    }


//    override fun onClick(v: View?) {
//        if(v != null && v.id == R.id.payment){
//            Log.d("Demo","Pay Clicked")
//            PaymentGateway.pay(100, requireActivity())
//        }
//        else if(v != null && v.id == R.id.practice_mode){
//            Log.d("Demo","Practice Mode Clicked")
////            val intent = Intent(activity, PracticeMode::class)
////            startActivity(intent)
//        }
//        else if(v != null && v.id == R.id.btn_payment_history){
//            Toast.makeText(activity,"TODO Later",Toast.LENGTH_LONG).show()
////            val intent = Intent(activity, PaymentHistory::class.java)
////            startActivity(intent)
//        }
//
//    }



}