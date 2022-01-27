package com.main.app.fragments.practicemode

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.main.app.R
import com.main.app.practice.PMGameActivity
import com.main.app.utils.CompanyDetail
import kotlinx.android.synthetic.main.fragment_p_m_buy.*


class PMBuyFragment : Fragment() {


    private var sName: String? = ""
    private var sPrice: String? = ""
    lateinit var stockNameTV : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_p_m_buy, container, false)

        stockNameTV = view.findViewById(R.id.stockName)

        sName = arguments?.getString("NAME")
        sPrice = arguments?.getString("PRICE")

        Log.i("MY_LOG", sName.toString())

        stockNameTV.text = sName




        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setStockDetail(sName,sPrice)

        var newCurrency : String? = null


        buyQuantity.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    Log.i("MY_LOG","Inside before text changed")
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    Log.i("MY_LOG","Inside on text changed")
                }

                override fun afterTextChanged(s: Editable?) {
                    Log.i("MY_LOG","Inside after text changed")

                    val price : Int = Integer.parseInt(stockPrice.text.toString())
                    val quantity : Int = Integer.parseInt(buyQuantity.text.toString())
                    buyPrice.text =  (price*quantity).toString()
                    newCurrency = buyPrice.text as String

                }

            }
        )


        buyBtn.setOnClickListener(
            object : View.OnClickListener{
                override fun onClick(v: View?) {
                    PMGameActivity().updateCurrency(newCurrency)
                }

            }
        )
    }



    private fun setStockDetail(sName: String?, sPrice: String?) {

        Log.i("MY_LOG","Inside setStockDetails")
        Log.i("MY_LOG","sName: " + sName)

        val companyDetails = CompanyDetail()
        if (sName != null) {

            Thread(
                Runnable {

                       val pricef = companyDetails.getStockPrice(sName).toString()
                        Log.i("MY_LOG","showing some context error")

                        activity?.runOnUiThread {
                            stockPrice.text = pricef
                            buyPrice.text = (Integer.parseInt(stockPrice.text.toString()) * Integer.parseInt(stockPrice.text.toString())).toString()
                        }

                }
            ).start()

        }
        else{
            stockPrice.text = sPrice
        }

    }

}