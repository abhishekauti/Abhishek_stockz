package com.main.app.fragments.practicemode

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.main.app.R
import com.main.app.utils.CompanyDetail
import kotlinx.android.synthetic.main.activity_pm_game.*
import kotlinx.android.synthetic.main.fragment_p_m_sell.*

class PMSellFragment : Fragment() {

    private var s_name: String? = ""
    private var s_price: String? = ""
    lateinit var stocknameTV: TextView
    lateinit var stockPriceTV: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_p_m_sell, container, false)

        s_name = arguments?.getString("NAME")
        s_price = arguments?.getString("PRICE")

        Log.i("MY_LOG", s_name.toString())

        stocknameTV = view.findViewById(R.id.stockName)
        stockPriceTV = view.findViewById(R.id.stockPrice)


        stocknameTV.text = s_name


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setStockDetail(s_name, s_price)

        var stockSellAmount : String? = null

        incrementBtn.setOnClickListener(
            object : View.OnClickListener{
                override fun onClick(v: View?) {
                    var quantity = sellQuantity.text.toString().toInt()
                    quantity += 1
                    sellQuantity.text = quantity.toString()

                    val price  = stockPrice.text.toString().toDouble()
                    var amount  = (price*quantity).toString()
                    sellPrice.text =  amount
                    stockSellAmount = sellPrice.text.toString()
                }
            }
        )

        decrementBtn.setOnClickListener(
            object : View.OnClickListener {
                override fun onClick(v: View?) {
                    var quantity = sellQuantity.text.toString().toInt()
                    quantity -= 1
                    sellQuantity.text = quantity.toString()

                    val price  = stockPrice.text.toString().toDouble()
                    var amount  = (price*quantity).toString()
                    sellPrice.text =  amount
                    stockSellAmount = sellPrice.text.toString()
                }
            }
        )


        sellBtn.setOnClickListener(
            object : View.OnClickListener{
                override fun onClick(v: View?) {
                    stockSellAmount = sellPrice.text.toString()
                    updateCurrency(stockSellAmount)
                }

            }
        )
    }

    private fun updateCurrency(stockBuyAmount: String?) {
        var currencyTV = requireActivity().findViewById<TextView>(R.id.currency)
        val currency = currencyTV.text.toString().toDouble()
        if (stockBuyAmount!!.toDouble() < currency){
            try {
                val updatedValue  = currency + stockBuyAmount.toDouble()
                requireActivity().currency.text = updatedValue.toString()
            }
            catch (e : Exception){
                Log.v("MY_LOG","Exception in update currency: "+e.printStackTrace())
            }

        }
        else{
            Toast.makeText(context,"You don't have enough currency", Toast.LENGTH_LONG).show()
        }


    }


    private fun setStockDetail(s_name: String?, s_price: String?) {
        val companyDetails = CompanyDetail()
        if (s_name != null) {
            Thread(
                Runnable {
                    var pricef = companyDetails.getStockPrice(s_name).toString()
                    activity?.runOnUiThread {
                        stockPriceTV.text = pricef
                        var sellingPrice = (stockPrice.text.toString().toDouble())*(sellQuantity.text.toString().toDouble())
                        sellPrice.text = sellingPrice.toString()
                    }

                }
            ).start()

        } else {
            stockPriceTV.text = "Error"
        }

    }
}
