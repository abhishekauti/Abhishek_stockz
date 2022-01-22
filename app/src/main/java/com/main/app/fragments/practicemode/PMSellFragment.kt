package com.main.app.fragments.practicemode

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.main.app.R
import com.main.app.utils.CompanyDetail

class PMSellFragment : Fragment() {

    private var stockName: String? = ""
    private var stockPrice: String? = ""
    lateinit var logoview: ImageView
    lateinit var stocknameTV: TextView
    lateinit var stockPriceTV: TextView
    lateinit var sellQuantityET: EditText
    lateinit var sellPriceTv: TextView
    lateinit var sellBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_p_m_sell, container, false)

        stockName = arguments?.getString("NAME")
        stockPrice = arguments?.getString("PRICE")

        Log.i("MY_LOG", stockName.toString())

        logoview = view.findViewById(R.id.stockLogo)
        stocknameTV = view.findViewById(R.id.stockName)
        sellQuantityET = view.findViewById(R.id.sellQuantity)
        sellPriceTv = view.findViewById(R.id.sellPrice)
        sellBtn = view.findViewById(R.id.sellBtn)
        stockPriceTV = view.findViewById(R.id.stockPrice)

        setStockDetail(stockName, stockPrice)

        stocknameTV.text = stockName


        return view
    }

    private fun setStockDetail(stockName: String?, stockPrice: String?) {
        val companyDetails = CompanyDetail()
        if (stockName != null) {
            Thread(
                Runnable {
                    var pricef = companyDetails.getStockPrice(stockName).toString()
                    activity?.runOnUiThread {
                        stockPriceTV.text = pricef

                    }

                }
            ).start()

        } else {
            stockPriceTV.text = "Error"
        }

    }
}
