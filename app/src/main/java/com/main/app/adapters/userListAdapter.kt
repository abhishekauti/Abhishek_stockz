package com.main.app.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.main.app.R
import com.main.app.User

class userListAdapter(private val context :Activity, private val arrayList: ArrayList<User>):ArrayAdapter<User>(context,
R.layout.list_item, arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater= LayoutInflater.from(context)
        val view: View=inflater.inflate(R.layout.list_item,null)

        val imageView: ImageView=view.findViewById(R.id.profilePicture)
        val username: TextView=view.findViewById(R.id.personName)
        val status: TextView=view.findViewById(R.id.gameInfo)

        imageView.setImageResource(arrayList[position].imageId)
        username.text=arrayList[position].name
        status.text=arrayList[position].status


        return view
    }
}