package com.main.app.practice

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.main.app.R
import com.main.app.fragments.practicemode.FragmentPortfolioPM
import com.main.app.fragments.practicemode.FragmentPositionPM


class Position : AppCompatActivity() {

    companion object{
        const val TIMER = "TIMER"
        const val CURRENCY = "CURRENCY"
    }
    lateinit var viewPager: ViewPager2
    lateinit var tabLayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_position)

        val toolbar : androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        viewPager = findViewById(R.id.pmViewPager)
        tabLayout = findViewById(R.id.pmTabLayout)


        val adapter = PMViewPagerAdapter(supportFragmentManager,lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout,viewPager){tab,
        position -> when(position) {
            0 -> tab.text = "Position"
            1 -> tab.text = "Portfolio"
        }}.attach()

        val timer = intent.getStringExtra(TIMER)
        val currency = intent.getStringExtra(CURRENCY)

        val timerText = findViewById<TextView>(R.id.timer);
        val currencyText = findViewById<TextView>(R.id.currency);

        timerText.text = timer
        currencyText.text = currency



    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.position_nav_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onBackPressed() {
        Toast.makeText(this, "To go back, Exit the Game or play the Game..!", Toast.LENGTH_LONG).show()
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

class PMViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(
        fragmentManager,
        lifecycle
    ) {

    override fun getItemCount(): Int {
        return 2
        //no of tabbed pages
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> return FragmentPositionPM()

            1 -> return FragmentPortfolioPM()
            //when postion = 0, it'll automatically retun FragmentPosition
            else -> return FragmentPositionPM()

        }
    }

}

