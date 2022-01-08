package com.main.app.fragments.practicemode

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.main.app.Common
import com.main.app.Communicator
import com.main.app.R
import org.json.JSONException
import org.json.JSONObject
import java.util.*
import kotlin.collections.ArrayList

class FragmentPositionPM : Fragment(),Communicator {
    class StockDataModel(
        var companyName: String,
        var close: String,
        var changes: String)

    lateinit var mtopGainersList: ArrayList<StockDataModel>
    lateinit var mtopLosersList: ArrayList<StockDataModel>

    lateinit var gainerRecyclerView: RecyclerView
    lateinit var loserRecyclerView : RecyclerView
    var currentcontext = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       return inflater.inflate(R.layout.fragment_postion_p_m, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loserRecyclerView = view.findViewById(R.id.losers_recycle_view)
        getToploserData(context,loserRecyclerView)

        gainerRecyclerView = view.findViewById(R.id.gainers_recycle_view)
        getTopGainerData(context,gainerRecyclerView)

        Common.comm = this
    }


    fun getToploserData(context: Context?, loserRecyclerView: RecyclerView?) {
        val jsonUrl = "https://financialmodelingprep.com/api/v3/stock/losers?apikey=16f76bfbe6000fa20d62d1a9d78b53b8"

        mtopLosersList = ArrayList()



        var requestQueue: RequestQueue = Volley.newRequestQueue(context)

        var jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            jsonUrl,
            null,
            Response.Listener
            {

                    response ->

                try {
                    val toplosers = response.getJSONArray("mostLoserStock")
                    try {

                        for (i in 0 .. toplosers.length()-1) {
                            val articleObj: JSONObject = toplosers.getJSONObject(i)
                            val companyName: String = articleObj.getString("companyName")
                            val close: String = articleObj.getString("price")
                            val changes: String = articleObj.getString("changes")
//                        val chart: String = articleObj.getString("chart")

                            val stockdata = StockDataModel(companyName, close, changes)

                            stockdata.companyName = companyName
                            stockdata.close = close
                            stockdata.changes = changes

                            mtopLosersList.add(stockdata)

                        }
                    }
                    catch (e : Exception){
                        e.printStackTrace()
                    }

                    if (loserRecyclerView != null) {
                        loserRecyclerView.layoutManager =
                            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    }
                    val toplosersAdapter: TopLosersAdapter = TopLosersAdapter(context, mtopLosersList)
                    if (loserRecyclerView != null) {
                        loserRecyclerView.adapter = toplosersAdapter
                    }


                } catch (e: JSONException) {
                    e.printStackTrace()
                }

            },
            { error ->
                Toast.makeText(context, "Fail to get Loser's Data", Toast.LENGTH_SHORT).show()
            }
        )



        requestQueue.add(jsonObjectRequest)

    }

    fun getTopGainerData(context: Context?, gainerRecyclerView: RecyclerView?) {
        val jsonUrl = "https://financialmodelingprep.com/api/v3/stock/gainers?apikey=16f76bfbe6000fa20d62d1a9d78b53b8"

        mtopGainersList = ArrayList()

        var requestQueue: RequestQueue = Volley.newRequestQueue(context)

        var jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            jsonUrl,
            null,
            {

                    response ->

                try {
                    val topGainers = response.getJSONArray("mostGainerStock")
                    try {
                        for (i in 0 .. topGainers.length()-1) {
                            val articleObj: JSONObject = topGainers.getJSONObject(i)
                            val companyName: String = articleObj.getString("companyName")
                            val close: String = articleObj.getString("price")
                            val changes: String = articleObj.getString("changes")
//                        val chart: String = articleObj.getString("chart")

                            val stockdata = StockDataModel(companyName, close, changes)

                            stockdata.companyName = companyName
                            stockdata.close = close
                            stockdata.changes = changes

                            mtopGainersList.add(stockdata)

                        }

                    }
                    catch (e : Exception){
                        e.printStackTrace()
                    }


                    val topGainersAdapter: TopGainersAdapter = TopGainersAdapter(context, mtopGainersList)

                    if (gainerRecyclerView != null) {
                        gainerRecyclerView.layoutManager =
                            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    }
                    if (gainerRecyclerView != null) {
                        gainerRecyclerView.adapter = topGainersAdapter
                    }


                } catch (e: JSONException) {
                    e.printStackTrace()
                }

            },
            { error ->
                Toast.makeText(context, "Fail to get News Data", Toast.LENGTH_SHORT).show()
            }
        )



        requestQueue.add(jsonObjectRequest)
    }

    override fun run() {
        getTopGainerData(requireContext(),gainerRecyclerView)
        getToploserData(requireContext(),loserRecyclerView)
        Log.d("Demo","Done")
    }


}


class TopGainersAdapter(val context: Context?, val topgainers: ArrayList<FragmentPositionPM.StockDataModel>) : RecyclerView.Adapter<TopGainersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(
            R.layout.movers_layout,
            viewGroup,
            false
        )
        return ViewHolder(view)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each item to
        val companyName: TextView = view.findViewById(R.id.stock_name)
        val close: TextView = view.findViewById(R.id.stock_closingvalue)
        val changes: TextView = view.findViewById(R.id.stock_changevalue)
        val chart: ImageView = view.findViewById(R.id.stock_chart)

        init{
            view.setOnClickListener(View.OnClickListener {
                val position = adapterPosition
                // start stock screen


            })
        }

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = topgainers.get(position)
        holder.companyName.text = item.companyName
        holder.close.text = item.close
        holder.changes.text = item.changes

    }


    override fun getItemCount(): Int {
        return topgainers.size
    }
}


class TopLosersAdapter(val context: Context?, val toplosers: ArrayList<FragmentPositionPM.StockDataModel>) : RecyclerView.Adapter<TopLosersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(
            R.layout.movers_layout,
            viewGroup,
            false
        )
        return ViewHolder(view)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each item to
        val companyName: TextView = view.findViewById(R.id.stock_name)
        val close: TextView = view.findViewById(R.id.stock_closingvalue)
        val changes: TextView = view.findViewById(R.id.stock_changevalue)
        val chart: ImageView = view.findViewById(R.id.stock_chart)

        init{
            view.setOnClickListener(View.OnClickListener {
                val position = adapterPosition
                // start stock screen

            })
        }


    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = toplosers.get(position)
        holder.companyName.text = item.companyName
        holder.close.text = item.close
        holder.changes.text = item.changes


    }


    override fun getItemCount(): Int {
        return toplosers.size
    }
}



