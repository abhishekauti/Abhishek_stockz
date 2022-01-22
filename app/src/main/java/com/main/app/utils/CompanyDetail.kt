package com.main.app.utils

import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class CompanyDetail {

    fun getStockPrice(stockName: String) : Double {
        val url = "https://www.google.com/finance/quote/"+stockName+":NSE"
        var price : Double = 0.0
        var doc : Document



                    try {
                        doc =
                            Jsoup.connect(url)
                                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:95.0) Gecko/20100101 Firefox/95.0")
                                .get()
                        price = doc.getElementsByClass("YMlKec fxKbKc").text().removePrefix("₹")
                            .replace(",", "").toDouble()
                        Log.i("MY_LOG", price.toString())

                    } catch (e: Exception) {
                        print("Error at link: " + url)
                    }


        return price
    }



}