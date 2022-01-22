//package com.main.app.dao

import okhttp3.OkHttpClient
import org.jsoup.Jsoup

class Test {
}

//twelvedata : 9ce7c6dd67a246bbaa8ff7335dd266c2
fun main() {
    val client = OkHttpClient()

    val stockName = "TCS"
    val url = "https://www.google.com/finance/quote/"+stockName+":NSE"

    try {
//        println("varsha_Title" + doc.title())

        val doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:95.0) Gecko/20100101 Firefox/95.0").get()
        val price = doc.getElementsByClass("YMlKec fxKbKc").text().removePrefix("₹")
            .replace(",", "").toDouble()
    print(price)
    }
    catch (e : Exception){
        print("ERROR: varsha")
    }

}
