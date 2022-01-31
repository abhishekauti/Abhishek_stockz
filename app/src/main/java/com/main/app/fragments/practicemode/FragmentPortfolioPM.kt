package com.main.app.fragments.practicemode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.main.app.R
import com.main.app.adapters.RecyclerPortfilioAdapter
import com.main.app.singleton.ViewClassData

class FragmentPortfolioPM : Fragment() {

    lateinit var recyclerview : RecyclerView

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

        recyclerview = view.findViewById(R.id.recyclerview)

        val data = ArrayList<ViewClassData>()

        for (i in 1..20) {
            data.add(ViewClassData("name", "Item " + i))
        }

        val adapter = RecyclerPortfilioAdapter(data)

        recyclerview.adapter=adapter

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