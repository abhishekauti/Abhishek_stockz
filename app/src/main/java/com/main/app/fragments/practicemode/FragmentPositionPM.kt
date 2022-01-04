package com.main.app.fragments.practicemode

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.main.app.R
import org.json.JSONException
import org.json.JSONObject
import java.util.*

class FragmentPositionPM : Fragment() {
    class StockDataModel(
        var companyName: String,
        var close: String,
        var changes: String)

    lateinit var gainerRecyclerView: RecyclerView
    lateinit var loserRecyclerView : RecyclerView
    private val jsonUrl = "https://financialmodelingprep.com/api/v3/stock/gainers?apikey=16f76bfbe6000fa20d62d1a9d78b53b8"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_postion_p_m, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gainerRecyclerView = view.findViewById(R.id.gainers_recycle_view)
        getTopGainersData(context,gainerRecyclerView)

//        loserRecyclerView = view.findViewById(R.id.losers_recycle_view)
//        getTopLosersData(context,loserRecyclerView)

    }

//    private fun getTopLosersData(context: Context?, loserRecyclerView: RecyclerView?) {
//
//        val toplosersList: ArrayList<StockDataModel> = ArrayList()
//
//
//        var requestQueue: RequestQueue = Volley.newRequestQueue(context)
//
//        var jsonObjectRequest = JsonObjectRequest(
//            Request.Method.GET,
//            jsonUrl,
//            null,
//
//            {
//
//                    response ->
//
//                try {
//                    val toplosers = response.getJSONArray("mostloserStock")
//
//                    for (i in 0..toplosers.length() - 1) {
//                        val articleObj: JSONObject = toplosers.getJSONObject(i)
//                        val companyName: String = articleObj.getString("companyName")
//                        val close: String = articleObj.getString("price")
//                        val changes: String = articleObj.getString("changes")
////                        val chart: String = articleObj.getString("chart")
//
//                        val stockdata = StockDataModel(companyName, close, changes)
//
//                        stockdata.companyName = companyName
//                        stockdata.close = close
//                        stockdata.changes = changes
//
//                        toplosersList.add(stockdata)
//
//                    }
//
//
//                    if (loserRecyclerView != null) {
//                        loserRecyclerView.layoutManager =
//                            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//                    }
//                    val toplosersAdapter: TopLosersAdapter = TopLosersAdapter(context, toplosersList)
//                    if (loserRecyclerView != null) {
//                        loserRecyclerView.adapter = toplosersAdapter
//                    }
//
//
//                } catch (e: JSONException) {
//                    e.printStackTrace()
//                }
//
//            },
//            { error ->
//                Toast.makeText(context, "Fail to get Losers Data", Toast.LENGTH_SHORT).show()
//            }
//        )
//
//
//
//        requestQueue.add(jsonObjectRequest)
//
//    }




    private fun getTopGainersData(context: Context?, gainerRecyclerView: RecyclerView?) {
        val gainersList : ArrayList<StockDataModel> = ArrayList()

        var requestQueue :RequestQueue = Volley.newRequestQueue(context)

        var jsonObjectRequest  = JsonObjectRequest(
            Request.Method.GET,
            jsonUrl,
            null,
            {

                    response ->

                try {
                    val topGainers = response.getJSONArray("mostGainerStock")

                    for (i in 0 .. topGainers.length()) {
                        val articleObj: JSONObject = topGainers.getJSONObject(i)
                        val companyName: String = articleObj.getString("companyName")
                        val close: String = articleObj.getString("price")
                        val changes: String = articleObj.getString("changes")
//                      val chart: String = articleObj.getString("chart")

                        val stockdata = StockDataModel(companyName, close, changes)

                        stockdata.companyName = companyName
                        stockdata.close = close
                        stockdata.changes = changes

                        gainersList.add(stockdata)

                    }


                    if (gainerRecyclerView != null) {
                        gainerRecyclerView.layoutManager =
                            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    }
                    val topGainersAdapter = TopGainersAdapter(context, gainersList)
                    if (gainerRecyclerView != null) {
                        gainerRecyclerView.adapter = topGainersAdapter
                    }


                } catch (e: JSONException) {
                    e.printStackTrace()
                }

            },
            { error ->
                Toast.makeText(context, "Fail to get Top Gainers Data", Toast.LENGTH_SHORT).show()
            }
        )
        requestQueue.add(jsonObjectRequest)


    }


}
/*
//class TopLosersAdapter(val context: Context?, val toplosers: ArrayList<FragmentPositionPM.StockDataModel>) : RecyclerView.Adapter<TopLosersAdapter.ViewHolder>() {
//
//    override fun onCreateViewHolder(
//        viewGroup: ViewGroup,
//        viewType: Int
//    ): TopLosersAdapter.ViewHolder {
//        val view = LayoutInflater.from(viewGroup.context).inflate(
//            R.layout.movers_layout,
//            viewGroup,
//            false
//        )
//        return ViewHolder(view)
//    }
//
//    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        // Holds the TextView that will add each item to
//        val companyName: TextView = view.findViewById(R.id.stock_name)
//        val close: TextView = view.findViewById(R.id.stock_closingvalue)
//        val changes: TextView = view.findViewById(R.id.stock_changevalue)
////        val chart: ImageView = view.findViewById(R.id.loser_chart)
//
//
//    }
//
//
//    override fun onBindViewHolder(holder: TopLosersAdapter.ViewHolder, position: Int) {
//
//        val item = toplosers.get(position)
//        holder.companyName.text = item.companyName.toString()
//        holder.close.text = item.close.toString()
//        holder.changes.text = item.changes.toString()
//
//    }
//
//
//    override fun getItemCount(): Int {
//        return toplosers.size
//    }
//}
*/

class TopGainersAdapter(val context: Context?, val topGainers: ArrayList<FragmentPositionPM.StockDataModel>)
    : RecyclerView.Adapter<TopGainersAdapter.ViewHolder>() {

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
//        val chart: ImageView = view.findViewById(R.id.gainer_chart)

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = topGainers.get(position)
        holder.companyName.text = item.companyName.toString()
        holder.close.text = item.close.toString()
        holder.changes.text = item.changes.toString()

    }


    override fun getItemCount(): Int {
        return topGainers.size
    }
}
