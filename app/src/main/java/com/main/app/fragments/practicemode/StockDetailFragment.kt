package com.main.app.fragments.practicemode

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.main.app.R

class StockDetailFragment : Fragment() {

    private val apiKey = "WK0JPYNRCEDDXUM9"
    private var stockName: String? = ""
    private lateinit var stockUrl : String
    lateinit var buyBtn : Button
    lateinit var sellBtn : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_stock_detail, container, false)

        stockName = arguments?.getString("S_NAME")
        Log.i("MY_LOG", stockName.toString())

        stockUrl = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="+stockName+".BSE&outputsize=full&apikey="+apiKey

        buyBtn = view.findViewById(R.id.buyBtn)
        sellBtn = view.findViewById(R.id.sellBtn)

        buyBtn.setOnClickListener{
            fragmentManager?.beginTransaction()
                ?.replace(R.id.pmgameactivity_fragment_container,PMBuyFragment())?.commit()
        }

        sellBtn.setOnClickListener{
            fragmentManager?.beginTransaction()
                ?.replace(R.id.pmgameactivity_fragment_container,PMSellFragment())?.commit()
        }

        return view
    }

}