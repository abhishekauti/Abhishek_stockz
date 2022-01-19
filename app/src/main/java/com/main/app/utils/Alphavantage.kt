package com.main.app.utils

import com.crazzyghost.alphavantage.AlphaVantage
import com.crazzyghost.alphavantage.Config

class Alphavantage {

    fun setupAlphavantage(){



        val cfg: Config = Config.builder()
            .key("#&ALPHA10100DEMOKEY")
            .timeOut(10)
            .build()

        AlphaVantage.api().init(cfg);
    }
}