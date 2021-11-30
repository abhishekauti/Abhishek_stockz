package com.main.app

import android.content.Context
import android.media.audiofx.DynamicsProcessing
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.main.app.models.StockDetail
import org.json.JSONObject
import java.lang.reflect.Method
import io.finnhub.api.apis.DefaultApi
import io.finnhub.api.infrastructure.ApiClient
import io.finnhub.api.models.StockSymbol

val ApiClient = ApiClient


class DataSource {
    companion object{
        fun getDataSet(): ArrayList<StockDetail>{

            ApiClient.apiKey["token"] = "c4abgbiad3if78059vsg"
            val apiClient = DefaultApi()



            val list = ArrayList<StockDetail>()
//            val jsonUrl = "https://financialmodelingprep.com/api/v3/stock-screener?marketCapMoreThan=10000&betaMoreThan=1&volumeMoreThan=10000&dividendMoreThan=0&limit=100&apikey=16f76bfbe6000fa20d62d1a9d78b53b8"

//           val apiKey = "16f76bfbe6000fa20d62d1a9d78b53b8"
//            val timeout = 3000

//            val stockName = apiClient.


            list.add(
                StockDetail(
                    "Vodafone Idea", "Vodafone Idea", 10.30, 4.57
                )
            )

            list.add(
                StockDetail(
                    "Tata Steel", "Tata", 1287.50, 12.35
                )
            )

            list.add(
                StockDetail(
                    "Zomato", "Zomato", 153.00, 12.10
                )
            )

            list.add(
                StockDetail(
                    "Nykaa", "Nykaa", 2358.30, 144.75
                )
            )

            list.add(
                StockDetail(
                    "ICICI Bank", "ICICI", 776.60, 5.15
                )
            )

            list.add(
                StockDetail(
                    "Vodafone Idea", "Vodafone Idea", 10.30, 4.57
                )
            )

            list.add(
                StockDetail(
                    "Tata Steel", "Tata", 1287.50, 12.35
                )
            )

            list.add(
                StockDetail(
                    "Zomato", "Zomato", 153.00, 12.10
                )
            )

            list.add(
                StockDetail(
                    "Nykaa", "Nykaa", 2358.30, 144.75
                )
            )

            list.add(
                StockDetail(
                    "ICICI Bank", "ICICI", 776.60, 5.15
                )
            )

            list.add(
                StockDetail(
                    "Vodafone Idea", "Vodafone Idea", 10.30, 4.57
                )
            )

            list.add(
                StockDetail(
                    "Tata Steel", "Tata", 1287.50, 12.35
                )
            )

            list.add(
                StockDetail(
                    "Zomato", "Zomato", 153.00, 12.10
                )
            )

            list.add(
                StockDetail(
                    "Nykaa", "Nykaa", 2358.30, 144.75
                )
            )

            list.add(
                StockDetail(
                    "ICICI Bank", "ICICI", 776.60, 5.15
                )
            )

            return list;
        }
    }
}