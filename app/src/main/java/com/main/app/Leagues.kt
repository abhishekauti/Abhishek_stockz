package com.main.app

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import android.widget.AdapterView.OnItemClickListener


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
        //val createGame=findViewById<Button>(R.id.createGame)


        var arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, timeFrame)

        gameview.setAdapter(arrayAdapter)
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
        val temp=value.split(" ").toTypedArray()
        val time=temp[0]

//        createGame.setOnClickListener {
//            val intent = Intent(this, position::class.java)
//        }


    }
//    fun showAlertDialog(view: View){
//        CustomDialog().show(supportFragmentManager,"dialog cc")
//
//
//    }
}