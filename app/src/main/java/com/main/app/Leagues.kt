package com.main.app

import android.content.Intent
import android.icu.text.Transliterator
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.main.app.practice.Position

class Leagues : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leagues)
        //get array of gameplay
        val gameplay=resources.getStringArray(R.array.gameplay)
        val marketPlace=resources.getStringArray(R.array.marketplace)
        val timeFrame = resources.getStringArray(R.array.timeframe)
        val entryFees= resources.getStringArray(R.array.EntryFees)
        val tournamentSize=resources.getStringArray(R.array.tournamentSize)
        val visibility = resources.getStringArray(R.array.visibility)



        val gameview=findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        val marketview=findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView2)
        val timeview=findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView3)
        val entryview=findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView4)
        val tournamentview=findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView5)
        val visibilityview=findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView6)
        val createGame=findViewById<Button>(R.id.createGame)

        //adapter added
        var arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, timeFrame)
        var arrayAdapterTime = ArrayAdapter(this, R.layout.dropdown_item ,gameplay)

        gameview.setAdapter(arrayAdapterTime)
        marketview.setAdapter(arrayAdapter)
        timeview.setAdapter(arrayAdapter)
        entryview.setAdapter(arrayAdapter)
        tournamentview.setAdapter(arrayAdapter)
        visibilityview.setAdapter(arrayAdapter)
        var value:String=""
        timeview.setOnItemClickListener { parent, view, position, id ->
            val selectedvalue=arrayAdapter.getItem(position)
            if (selectedvalue != null) {
                value=selectedvalue
            }
            // Toast.makeText(this@Leagues , "Item ", Toast.LENGTH_SHORT).show()
        }
        var temp=value.split(" ").toTypedArray()
        val time=temp[0]

        var gameVal:String=""
        gameview.setOnItemClickListener { parent, view, position, id ->
            val selectedvalue = arrayAdapterTime.getItem(position)
            if(selectedvalue != null){
                gameVal=selectedvalue
            }
        }
        temp = value.split("").toTypedArray()
        val diamonds = temp[0]


        createGame.setOnClickListener {
            val intent = Intent(this@Leagues , Position::class.java )
            intent.putExtra(Position.TIMER , time)
            intent.putExtra(Position.CURRENCY , diamonds)

            startActivity(intent)
        }


    }
//    fun showAlertDialog(view: View){
//        CustomDialog().show(supportFragmentManager,"dialog cc")
//
//
//    }
}