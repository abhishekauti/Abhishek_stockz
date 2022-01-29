package com.main.app.practice

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.main.app.Home
import com.main.app.R
import com.main.app.fragments.practicemode.FragmentTabbedPM
import kotlinx.android.synthetic.main.activity_pm_game.*
import kotlinx.coroutines.runBlocking


class PMGameActivity : AppCompatActivity() {
    companion object{
        const val TIMER = "TIMER"
        const val CURRENCY = "CURRENCY"
    }
    lateinit var timer: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pm_game)

        val toolbar : androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        timer = findViewById(R.id.timer)

        currency.text = getCurrency()

//        //anonmyous timer for the app bar
runBlocking {
    object : CountDownTimer(300000,1000) {
        override fun onTick(millisUntilFinished: Long) {
            val totalsec = (millisUntilFinished / 1000)
            val min = totalsec/60
            val sec = totalsec%60
            timer.text = ""+ min + ":" + sec
        }

        override fun onFinish() {
            val intent = Intent(this@PMGameActivity, Home::class.java)
            startActivity(intent)
            finish()
        }
    }.start()

}

        this.supportFragmentManager.beginTransaction().replace(
            R.id.pmgameactivity_fragment_container,
            FragmentTabbedPM()
        ).commit()

    }



    private fun getCurrency(): String {
//        TODO("return the value of coins present in actual portfolio of user, get the value from HomeScreen")

        return "100000"
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.position_nav_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){

            R.id.nav_exit -> {
                Toast.makeText(this, "Third item Selected", Toast.LENGTH_SHORT).show()
                finish()
                return true
            }
            else ->{
                return super.onOptionsItemSelected(item)
            }
        }

    }


}

