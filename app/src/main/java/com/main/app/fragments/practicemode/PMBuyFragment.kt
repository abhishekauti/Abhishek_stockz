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
import com.main.app.singleton.SocketHandler
import com.main.app.utils.CompanyDetail
import io.socket.client.Socket
import kotlinx.android.synthetic.main.activity_pm_game.*
import kotlinx.android.synthetic.main.fragment_p_m_buy.*
import org.json.JSONObject


class PMBuyFragment : Fragment() {

    lateinit var mSocket: Socket

    var quantity: Int = 0; //Total no. of quantity
    var pricef=""   //Prise of stock
    private var sName: String? = ""
    private var sPrice: String? = ""
    lateinit var stockPriceTV : TextView
    lateinit var stockNameTV : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_p_m_buy, container, false)

        stockNameTV = view.findViewById(R.id.stockName)
        stockPriceTV = view.findViewById(R.id.stockPrice)

        sName = arguments?.getString("NAME")
        sPrice = arguments?.getString("PRICE")

        Log.i("MY_LOG", sName.toString())

        stockNameTV.text = sName

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        SocketHandler.setSocket()
        SocketHandler.establishConnection()

        mSocket = SocketHandler.getSocket()

        setStockDetail(sName,sPrice)

        var stockBuyAmount : String? = null

        incrementBtn.setOnClickListener(
            object : View.OnClickListener{
                override fun onClick(v: View?) {
                     quantity= buyQuantity.text.toString().toInt()
                    quantity += 1
                    buyQuantity.text = quantity.toString()
                    Log.i("WHATTHIS","$quantity")
                    val price  = stockPrice.text.toString().toDouble()
                    var amount  = (price*quantity).toString()
                    buyPrice.text =  amount
                    stockBuyAmount = buyPrice.text.toString()
                }

            }
        )

        decrementBtn.setOnClickListener(
           object : View.OnClickListener {
               override fun onClick(v: View?) {
                   quantity = buyQuantity.text.toString().toInt()
                   quantity -= 1
                   buyQuantity.text = quantity.toString()
                   Log.i("WHATTHIS","$quantity")
                   val price  = stockPrice.text.toString().toDouble()
                   var amount  = (price*quantity).toString()
                   buyPrice.text =  amount
                   stockBuyAmount = buyPrice.text.toString()
               }
           }
        )

        buyBtn.setOnClickListener(
            object : View.OnClickListener{
                override fun onClick(v: View?) {
                    stockBuyAmount = buyPrice.text.toString()   //Total invested ammount
                    sendDatatoSocket(buyQuantity.text.toString().toDouble(),buyPrice.text.toString().toDouble())
                    updateCurrency(stockBuyAmount)
                }

            }
        )
    }

    private fun sendDatatoSocket(buyquantity: Double, buyprice: Double) {

    }

    private fun updateCurrency(stockBuyAmount: String?) {
        var currencyTV = requireActivity().findViewById<TextView>(R.id.currency)
        val currency = currencyTV.text.toString().toDouble()
        if (stockBuyAmount!!.toDouble() < currency){
            try {
                val updatedValue  = currency - stockBuyAmount.toDouble()
                requireActivity().currency.text = updatedValue.toString()
                var totalprofit=stockBuyAmount.toDouble() - pricef.toDouble()
                //sName stock name
                val data = JSONObject()
                data.put("name",sName)
                data.put("totalprofit",totalprofit)
                data.put("quantity",quantity)
                data.put("avg","avg")
                data.put("invested",stockBuyAmount.toDouble())
                data.put("percent","%5")
                mSocket.emit("counter",data)

            }
            catch (e : Exception){
                Log.v("MY_LOG","Exception in update currency: "+e.printStackTrace())
            }

        }
        else{
            Toast.makeText(context,"You don't have enough currency",Toast.LENGTH_LONG).show()
        }


    }


    private fun setStockDetail(sName: String?, sPrice: String?) {

        Log.i("MY_LOG","Inside setStockDetails")
        Log.i("MY_LOG","sName: " + sName)

        val companyDetails = CompanyDetail()
        if (sName != null) {

            Thread(
                Runnable {

                    pricef = companyDetails.getStockPrice(sName).toString()
                        Log.i("MY_LOG","showing some context error")

                        activity?.runOnUiThread {
                            stockPrice.text = pricef
                            val buyprice = (stockPrice.text.toString().toDouble())*(buyQuantity.text.toString().toDouble())
                            buyPrice.text = buyprice.toString()
                        }


                }
            ).start()

        }
        else{
            stockPrice.text = sPrice
        }

    }

}