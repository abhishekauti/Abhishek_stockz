package com.main.app

import com.main.app.models.StockDetail

class DataSource {
    companion object{
        fun getDataSet(): ArrayList<StockDetail>{
            val list = ArrayList<StockDetail>()
            list.add(
                StockDetail(
                "Vodafone Idea","Vodafone Idea",10.30,4.57
            )
            )

            list.add(StockDetail(
                "Tata Steel","Tata",1287.50,12.35
            ))

            list.add(StockDetail(
                "Zomato","Zomato",153.00,12.10
            ))

            list.add(StockDetail(
                "Nykaa","Nykaa",2358.30,144.75
            ))

            list.add(StockDetail(
                "ICICI Bank","ICICI",776.60,5.15
            ))

            list.add(
                StockDetail(
                    "Vodafone Idea","Vodafone Idea",10.30,4.57
                )
            )

            list.add(StockDetail(
                "Tata Steel","Tata",1287.50,12.35
            ))

            list.add(StockDetail(
                "Zomato","Zomato",153.00,12.10
            ))

            list.add(StockDetail(
                "Nykaa","Nykaa",2358.30,144.75
            ))

            list.add(StockDetail(
                "ICICI Bank","ICICI",776.60,5.15
            ))

            list.add(
                StockDetail(
                    "Vodafone Idea","Vodafone Idea",10.30,4.57
                )
            )

            list.add(StockDetail(
                "Tata Steel","Tata",1287.50,12.35
            ))

            list.add(StockDetail(
                "Zomato","Zomato",153.00,12.10
            ))

            list.add(StockDetail(
                "Nykaa","Nykaa",2358.30,144.75
            ))

            list.add(StockDetail(
                "ICICI Bank","ICICI",776.60,5.15
            ))

            return list;
        }
    }
}