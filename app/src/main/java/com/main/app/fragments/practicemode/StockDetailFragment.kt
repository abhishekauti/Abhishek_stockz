package com.main.app.fragments.practicemode

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.main.app.R
import com.main.app.utils.CompanyDetail

class StockDetailFragment : Fragment() {

    private var stockName: String? = ""
    private var stockPrice : String? = ""
    private var pricef : String = ""
    lateinit var buyBtn : Button
    lateinit var sellBtn : Button
    lateinit var stockNameTV : TextView
    lateinit var stockPriceTV : TextView
    lateinit var bundle : Bundle


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_stock_detail, container, false)

        bundle = Bundle()

        stockName = arguments?.getString("S_NAME")
        stockPrice = arguments?.getString("S_PRICE")

        Log.i("MY_LOG", stockName.toString())

        buyBtn = view.findViewById(R.id.buyBtn)
        sellBtn = view.findViewById(R.id.sellBtn)
        stockNameTV = view.findViewById(R.id.stockName)
        stockPriceTV = view.findViewById(R.id.stockPrice)


        setStockDetail(stockName,stockPrice)

        stockNameTV.text = stockName

        buyBtn.setOnClickListener{
            val sName: String = view!!.findViewById<TextView>(R.id.stockName).text as String
            val sPrice: String = view!!.findViewById<TextView>(R.id.stockPrice).text as String
            bundle.putString("NAME",sName)
            bundle.putString("PRICE",sPrice)
            PMBuyFragment().arguments = bundle
            requireFragmentManager().beginTransaction()
                .replace(R.id.pmgameactivity_fragment_container,PMBuyFragment::class.java,bundle).addToBackStack(null).commit()
        }

        sellBtn.setOnClickListener{
            val sName: String = view!!.findViewById<TextView>(R.id.stockName).text as String
            val sPrice: String = view!!.findViewById<TextView>(R.id.stockPrice).text as String
            bundle.putString("NAME",sName)
            bundle.putString("PRICE",sPrice)
            PMBuyFragment().arguments = bundle
            fragmentManager?.beginTransaction()
                ?.replace(R.id.pmgameactivity_fragment_container,PMSellFragment::class.java,bundle)?.addToBackStack(null)?.commit()
        }
        return view
    }

    private fun setStockDetail(stockName: String?, stockPrice: String?) {
        val companyDetails = CompanyDetail()
        if (stockName != null) {
            Thread(
                Runnable {
                    pricef = companyDetails.getStockPrice(stockName).toString()
                    activity?.runOnUiThread {
                        stockPriceTV.text = pricef

                    }

                }
            ).start()

        }
        else{
            stockPriceTV.text = "Error"
        }


    }


}