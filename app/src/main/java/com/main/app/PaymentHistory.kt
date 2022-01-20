package com.main.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.main.app.adapters.PaymentHistoryAdapter
import com.main.app.models.Payment

class PaymentHistory: AppCompatActivity() {

    private lateinit var data: ArrayList<Payment>
    private lateinit var paymentHistoryAdapter: PaymentHistoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        initRecyclerView()
        addData()

    }
    private fun addData(){
        paymentHistoryAdapter.submitList(data)
    }

    private fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.rv_payment_history)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@PaymentHistory)
            paymentHistoryAdapter = PaymentHistoryAdapter()
            adapter = paymentHistoryAdapter
        }
    }
}