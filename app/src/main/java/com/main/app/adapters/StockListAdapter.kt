package com.main.app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.main.app.R
import com.main.app.models.StockDetail

class StockListAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var stockList = ArrayList<StockDetail>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return StockViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_stocks,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is StockViewHolder -> {
                holder.bind(stockList.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return stockList.size
    }

    fun submitList(list: ArrayList<StockDetail>){
        stockList = list
    }

    class StockViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val stockName = itemView.findViewById<TextView>(R.id.stock_name)
        val companyName = itemView.findViewById<TextView>(R.id.company_name)
        val stockPrice = itemView.findViewById<TextView>(R.id.stock_price)
        val percentChanged = itemView.findViewById<TextView>(R.id.percent_change)

        fun bind(stockDetail: StockDetail){
            stockName.setText(stockDetail.stockName)
            companyName.setText(stockDetail.companyName)
            stockPrice.setText(stockDetail.stockPrice.toString())
            percentChanged.setText(stockDetail.changePercent.toString())
        }
    }
}


