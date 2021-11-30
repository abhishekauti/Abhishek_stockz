package com.main.app.models

data class StockDetail(
    var stockName : String,
    var companyName : String,
    var stockPrice : Double,
    var changePercent : Double
) {
}