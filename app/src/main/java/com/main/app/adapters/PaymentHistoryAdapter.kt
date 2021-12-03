package com.main.app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.main.app.R
import com.main.app.models.Payment

class PaymentHistoryAdapter: RecyclerView.Adapter<PaymentHistoryAdapter.PaymentViewHolder>() {

    var paymentList = ArrayList<Payment>()

    inner class PaymentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val pay_id = itemView.findViewById<TextView>(R.id.tv_pay_id)
    }

    fun submitList(list: ArrayList<Payment>){
        paymentList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        return PaymentViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_payment,parent,false))
    }


    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {
        holder.pay_id.setText(paymentList[position].payment_id)
    }

    override fun getItemCount(): Int {
        return paymentList.size
    }
}