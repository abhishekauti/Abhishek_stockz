package com.main.app.fragments.practicemode

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.main.app.R
import com.main.app.singleton.VollySingleTon
import kotlinx.android.synthetic.main.fragment_postion_p_m.*
import org.json.JSONException
import org.json.JSONObject
import java.util.*

class FragmentPositionPM : Fragment() {

    val list = arrayListOf<String>()

    class StockDataModel(
        var companyName: String,
        var close: String,
        var changes: String)
//Hello world
    lateinit var gainerRecyclerView: RecyclerView
    lateinit var loserRecyclerView : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       return inflater.inflate(R.layout.fragment_postion_p_m, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchView.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                showdata(s)

            }
        })

        searchView.onItemClickListener = AdapterView.OnItemClickListener{
                parent,view,position,id->
            val selectedItem = parent.getItemAtPosition(position).toString()
            // Display the clicked item using toast

            try {
                val bundle = Bundle()
                val yourArray: List<String> = selectedItem.split(".")
                bundle.putString("S_NAME", yourArray[0])
//                Toast.makeText(activity,""+result[0], android.widget.Toast.LENGTH_SHORT).show()
                val transaction = activity?.supportFragmentManager?.beginTransaction()
                val fragmentTwo = StockDetailFragment()
                fragmentTwo.arguments = bundle
                if (transaction != null) {
                    transaction.replace(R.id.pmgameactivity_fragment_container, fragmentTwo)
                    transaction.addToBackStack(null)
                    transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    transaction.commit()
                }

            }
            catch (e: Exception){
                Log.i("MY_LOG","Making topgainer clickable")
            }

//            intent = Intent(this, Secondactivity::class.java)
//            intent.putExtra("name", selectedItem)
//            startActivity(intent)

        }

        loserRecyclerView = view.findViewById(R.id.losers_recycle_view)
        try{
            getToploserData(context,loserRecyclerView)

        }
        catch (e : Exception){
            Log.e("MY_LOG","Error in getTopLosers")
        }

        gainerRecyclerView = view.findViewById(R.id.gainers_recycle_view)
        try{
            getTopGainerData(context,gainerRecyclerView)

        }
        catch (e : Exception){
            Log.e("MY_LOG","Error in getTopgainers")
        }

    }

    private fun showdata(s: CharSequence?) {

//        Toast.makeText(this,""+s,Toast.LENGTH_SHORT).show()

        val url = "https://www.alphavantage.co/query?function=SYMBOL_SEARCH&keywords="+s+".BSE&apikey=2AHJHWOLLN5AMNWP"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->

                if ( response.getJSONArray("bestMatches").length() > 0 ){

                    for (i in 0 until response.getJSONArray("bestMatches").length() ) {
                        val luck = response.getJSONArray("bestMatches").getJSONObject(i).getString("1. symbol")
                        list.add(luck)
                    }
                    val adapter =
                        activity?.let {
                            ArrayAdapter(
                                it,
                                android.R.layout.simple_list_item_1,
                                list
                            )
                        }
                    searchView.setAdapter(adapter)

                }
                else {
                    Toast.makeText(activity,"No Data Available", android.widget.Toast.LENGTH_SHORT).show()
                }

//                textView.text = "Response: %s".format(response.toString())
            },
            { error ->
                Toast.makeText(activity,""+error,Toast.LENGTH_SHORT).show()
            }
        )
        activity?.let { VollySingleTon.getInstance(it).addToRequestQueue(jsonObjectRequest) }

    }


    private fun getToploserData(context: Context?, loserRecyclerView: RecyclerView?) {
         val jsonUrl = "https://www1.nseindia.com/live_market/dynaContent/live_analysis/losers/niftyLosers1.json"

        val toplosersList: ArrayList<StockDataModel> = ArrayList()

        var requestQueue: RequestQueue = Volley.newRequestQueue(context)

        var jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            jsonUrl,
            null,
            Response.Listener
            {

                    response ->

                try {
                    val toplosers = response.getJSONArray("data")
try {

    for (i in 0 .. toplosers.length()-1) {
        val articleObj: JSONObject = toplosers.getJSONObject(i)
        val companyName: String = articleObj.getString("symbol")
        val close: String = articleObj.getString("ltp")
        val changes: String = articleObj.getString("netPrice") //loss%
//                        val chart: String = articleObj.getString("chart")

        val stockdata = StockDataModel(companyName, close, changes)

        stockdata.companyName = companyName
        stockdata.close = close
        stockdata.changes = changes

        toplosersList.add(stockdata)

    }
}
catch (e : Exception){
    e.printStackTrace()
}

                    if (loserRecyclerView != null) {
                        loserRecyclerView.layoutManager =
                            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    }
                    val toplosersAdapter: TopLosersAdapter = TopLosersAdapter(context, toplosersList)
                    if (loserRecyclerView != null) {
                        loserRecyclerView.adapter = toplosersAdapter
                    }
                    try {
                        toplosersAdapter.setOnItemClickListener(object : TopLosersAdapter.onItemClickListener{
                            override fun onItemClick(position: Int) {
                                val bundle = Bundle()
                                val sName: String = view!!.findViewById<TextView>(R.id.stock_name).text as String

                                bundle.putString("S_NAME", sName)
                                Log.i("MY_LOG","Stock Name for StockDetailPage: "+sName)
                                val fm = fragmentManager!!
                                StockDetailFragment().arguments = bundle
                                fm.beginTransaction().replace(R.id.pmgameactivity_fragment_container,StockDetailFragment()).addToBackStack(null).commit()

                            }
                        })
                    }
                    catch (e: Exception){
                        Log.i("MY_LOG","Making toploser clickable")
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

    private fun getTopGainerData(context: Context?, gainerRecyclerView: RecyclerView?) {
         val jsonUrl = "https://www1.nseindia.com/live_market/dynaContent/live_analysis/gainers/niftyGainers1.json"

        val topGainersList: ArrayList<StockDataModel> = ArrayList()

        var requestQueue: RequestQueue = Volley.newRequestQueue(context)

        var jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            jsonUrl,
            null,
            {
                    response ->

                try {
                    val topGainers = response.getJSONArray("data")
                    try {
                        for (i in 0 .. topGainers.length()-1) {
                            val articleObj: JSONObject = topGainers.getJSONObject(i)
                            val companyName: String = articleObj.getString("symbol")
                            val close: String = articleObj.getString("ltp")
                            val changes: String = articleObj.getString("netPrice")
//                        val chart: String = articleObj.getString("chart")

                            val stockdata = StockDataModel(companyName, close, changes)

                            stockdata.companyName = companyName
                            stockdata.close = close
                            stockdata.changes = changes

                            topGainersList.add(stockdata)

                        }

                    }
                    catch (e : Exception){
                        e.printStackTrace()
                    }


                    val topGainersAdapter = TopGainersAdapter(context, topGainersList)

                    if (gainerRecyclerView != null) {
                        Log.i("MY_LOG", "first if gainer")

                        gainerRecyclerView.layoutManager =
                            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    }
                    if (gainerRecyclerView != null) {
                        Log.i("MY_LOG","Second if gainer")
                        gainerRecyclerView.adapter = topGainersAdapter
                    }
                    try {
                        topGainersAdapter.setOnItemClickListener(object : TopGainersAdapter.onItemClickListener{
                            override fun onItemClick(position: Int) {
                                val bundle : Bundle = Bundle()
                                val sName: String = view!!.findViewById<TextView>(R.id.stock_name).text as String
                                val sPrice: String = view!!.findViewById<TextView>(R.id.stock_closingvalue).text as String
                                bundle.putString("S_NAME", sName)
                                bundle.putString("S_PRICE", sPrice)
                                Log.i("MY_LOG","Stock Name for StockDetailPage: "+sName)
                                var fm = fragmentManager
                                StockDetailFragment().arguments = bundle
                                if (fm != null) {
                                    fm.beginTransaction().replace(R.id.pmgameactivity_fragment_container,StockDetailFragment::class.java,bundle).addToBackStack(null).commit()
                                }

                            }
                        })
                    }
                    catch (e: Exception){
                        Log.i("MY_LOG","Making topgainer clickable")
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


}


class TopGainersAdapter(val context: Context?, val topgainers: ArrayList<FragmentPositionPM.StockDataModel>) : RecyclerView.Adapter<TopGainersAdapter.ViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(
            R.layout.movers_layout,
            viewGroup,
            false
        )
        return ViewHolder(view,mListener)
    }

    class ViewHolder(view: View, listener: onItemClickListener) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each item to
        val companyName: TextView = view.findViewById(R.id.stock_name)
        val close: TextView = view.findViewById(R.id.stock_closingvalue)
        val changes: TextView = view.findViewById(R.id.stock_changevalue)
//        val chart: ImageView = view.findViewById(R.id.stock_chart)

        init {
            view.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }


    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = topgainers.get(position)
        holder.companyName.text = item.companyName
        holder.close.text = item.close
        holder.changes.setTextColor(Color.GREEN)
        holder.changes.text = item.changes
        Log.i("MY_LOG", holder.companyName.text as String +" "+holder.changes.text.toString() )


    }


    override fun getItemCount(): Int {
        return topgainers.size
    }
}


class TopLosersAdapter(val context: Context?, val toplosers: ArrayList<FragmentPositionPM.StockDataModel>) : RecyclerView.Adapter<TopLosersAdapter.ViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(
            R.layout.movers_layout,
            viewGroup,
            false
        )
        return ViewHolder(view,mListener)
    }

    class ViewHolder(view: View, listener: onItemClickListener) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each item to
        val companyName: TextView = view.findViewById(R.id.stock_name)
        val close: TextView = view.findViewById(R.id.stock_closingvalue)
        val changes: TextView = view.findViewById(R.id.stock_changevalue)

//        val chart: ImageView = view.findViewById(R.id.stock_chart)
        init {
    view.setOnClickListener{
        listener.onItemClick(adapterPosition)
    }
}

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = toplosers[position]
        holder.companyName.text = item.companyName
        holder.close.text = item.close
        holder.changes.setTextColor(Color.RED)
        holder.changes.text = item.changes

    }


    override fun getItemCount(): Int {
        return toplosers.size
    }
}



