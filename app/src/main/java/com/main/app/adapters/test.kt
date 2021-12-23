package com.main.app.adapters

import io.finnhub.api.apis.DefaultApi
import io.finnhub.api.infrastructure.ApiClient
import java.text.SimpleDateFormat
import java.util.*

fun main() {

    ApiClient.apiKey["token"] = "c4abgbiad3if78059vsg"
    val apiClient = DefaultApi()
    //

    val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
    val date = sdf.format(Date())
    print(apiClient.stockTick("AAPL",date,5,1))
}