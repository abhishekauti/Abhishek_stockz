package com.main.app

import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import org.json.JSONObject

class PaymentGateway{
    companion object{
        fun pay(amt: Int, activity: Activity){
            val checkout = Checkout()
            checkout.setKeyID("rzp_test_el7TAs967VWLVd")
            Log.d("Demo","Checkout Created")
            val jsonObj = JSONObject()
            jsonObj.put("name","Celebro Team")
            jsonObj.put("description","Demo Payment")
            jsonObj.put("currency", "INR")
            jsonObj.put("amount", amt)
            jsonObj.put("prefill.contact", "9284064503")
            jsonObj.put("prefill.email", "demo@gmail.com")
            checkout.open(activity,jsonObj)
        }
    }
}