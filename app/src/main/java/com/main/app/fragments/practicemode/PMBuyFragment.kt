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


class PMBuyFragment : Fragment() {

    private var stockName : String? = ""
    private var stockPrice : String? = ""
    lateinit var logoview : ImageView
    lateinit var stocknameTV: TextView
    lateinit var stockExchangeTV:TextView
    lateinit var stockPriceTV : TextView
    lateinit var buyQuantityET : EditText
    lateinit var buyPriceTv : TextView
    lateinit var buyBtn : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_p_m_buy, container, false)

        stockName = arguments?.getString("NAME")
        stockPrice = arguments?.getString("PRICE")

        Log.i("MY_LOG", stockName.toString())

        logoview = view.findViewById(R.id.stockLogo)
        stocknameTV = view.findViewById(R.id.stockName)
        stockExchangeTV = view.findViewById(R.id.stockExchange)
        buyQuantityET = view.findViewById(R.id.buyQuantity)
        buyPriceTv = view.findViewById(R.id.buyPrice)
        buyBtn = view.findViewById(R.id.buyBtn)
        stockPriceTV = view.findViewById(R.id.stockPrice)

        setStockDetail(stockName,stockPrice)

        stocknameTV.text = stockName



//        buyQuantityET.addTextChangedListener(
//        object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                TODO("Not yet implemented")
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//                val price : Int = Integer.parseInt(stockPriceTV.text.toString())
//                val quantity : Int = Integer.parseInt(buyQuantityET.text.toString())
//                buyPriceTv.text =  (price*quantity).toString()
//            }
//
//        }
//        )

//        buyBtn.setOnClickListener(
//            object : View.OnClickListener{
//                override fun onClick(v: View?) {
//                    TODO("Not yet implemented")
//                }
//
//            }
//        )

        return view
    }

    private fun setStockDetail(stockName: String?, stockPrice: String?) {

        val companyDetails = CompanyDetail()
        if (stockName != null) {
            Thread(
                Runnable {
                    val pricef = companyDetails.getStockPrice(stockName).toString()
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