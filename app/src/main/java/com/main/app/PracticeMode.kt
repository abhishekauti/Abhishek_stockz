package com.main.app

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.main.app.adapters.StockListAdapter

class PracticeMode : AppCompatActivity(){

    private lateinit var stockListAdapter: StockListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.practice_mode_s)
        initRecyclerView()
        addData()
    }

    private fun addData(){
        val data = DataSource.getDataSet()
        stockListAdapter.submitList(data)
    }

    private fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.rv_stocks_list)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@PracticeMode)
            stockListAdapter = StockListAdapter()
            adapter = stockListAdapter
        }
    }
}