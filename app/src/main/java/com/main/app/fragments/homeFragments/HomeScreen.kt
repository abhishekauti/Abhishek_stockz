package com.main.app.fragments.homeFragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.main.app.PaymentGateway
import com.main.app.PracticeMode
import com.main.app.R
import com.razorpay.PaymentResultListener

class HomeScreen : Fragment(), View.OnClickListener ,PaymentResultListener{

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
        val pay = view.findViewById<Button>(R.id.payment)
        practiceMode.setOnClickListener(this)
        pay.setOnClickListener(this)
        return view;
    }

    override fun onClick(v: View?) {
        if(v != null && v.id == R.id.payment){
            Log.d("Demo","Pay Clicked")
            PaymentGateway.pay(100, requireActivity())
        }
        else if(v != null && v.id == R.id.practice_mode){
            Log.d("Demo","Practice Mode Clicked")
            val intent = Intent(activity, PracticeMode::class.java)
            startActivity(intent)
        }

    }
    override fun onPaymentSuccess(p0: String?) {
        Toast.makeText(activity,"Payment Successful"+p0, Toast.LENGTH_LONG).show()
    }
    override fun onPaymentError(p0: Int, p1: String?) {
        Toast.makeText(activity,"Payment UnSuccessful"+p1, Toast.LENGTH_LONG).show()
    }


}