package com.main.app

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity

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




        var arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, gameplay)

        gameview.setAdapter(arrayAdapter)
        marketview.setAdapter(arrayAdapter)
        timeview.setAdapter(arrayAdapter)
        entryview.setAdapter(arrayAdapter)
        tournamentview.setAdapter(arrayAdapter)
        visibilityview.setAdapter(arrayAdapter)


    }
    fun showAlertDialog(view: View){

    }
}