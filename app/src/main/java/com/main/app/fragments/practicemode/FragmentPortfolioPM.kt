package com.main.app.fragments.practicemode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.main.app.R

class FragmentPortfolioPM : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_portfolio_p_m, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
        investedMoney.text = TODO("total currency - money used in buying stocks")
        investedPercent.text = TODO("(invested money/100)*100 + % ")
        balance.text = TODO("portfolio balance left")
        stockValue.text = TODO()
        valuePercent.text = TODO()
        PLvalue.text = TODO("overall profit(+) or loss(-) of the stocks")
         */
    }
}