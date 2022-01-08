package com.main.app.practice

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.main.app.Common
import com.main.app.Home
import com.main.app.R
import com.main.app.fragments.practicemode.FragmentPortfolioPM
import com.main.app.fragments.practicemode.FragmentPositionPM


class Position : AppCompatActivity() {
    lateinit var viewPager: ViewPager2
    lateinit var tabLayout: TabLayout
    lateinit var refreshLayout: SwipeRefreshLayout
    lateinit var timer: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_position)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        viewPager = findViewById(R.id.pmViewPager)
        tabLayout = findViewById(R.id.pmTabLayout)
        refreshLayout = findViewById(R.id.pm_referesh_layout)
        timer = findViewById(R.id.pm_timer)


        val adapter = PMViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab,
                                                  position ->
            when (position) {
                0 -> tab.text = "Position"
                1 -> tab.text = "Portfolio"
            }
        }.attach()


        refreshLayout.setOnRefreshListener {
            // Reloading the data
            Common.comm?.run()
            refreshLayout.isRefreshing = false
        }

        //anonmyous timer for the app bar
        object : CountDownTimer(300000,1000) {
            override fun onTick(millisUntilFinished: Long) {
                val totalsec = (millisUntilFinished / 1000)
                val min = totalsec/60
                val sec = totalsec%60
                timer.text = ""+ min + ":" + sec
            }

            override fun onFinish() {
                val intent = Intent(this@Position, Home::class.java)
                startActivity(intent)
                finish()
            }
        }.start()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.position_nav_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onBackPressed() {
        Toast.makeText(this, "To go back, Exit the Game or play the Game..!", Toast.LENGTH_LONG)
            .show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.nav_exit -> {
                Toast.makeText(this, "Third item Selected", Toast.LENGTH_SHORT).show()
                finish()
                return true
            }
            else -> {
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

    lateinit var currentFragment: Fragment

    override fun getItemCount(): Int {
        return 2
        //no of tabbed pages
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> currentFragment = FragmentPositionPM()

            1 -> currentFragment = FragmentPortfolioPM()
            //when postion = 0, it'll automatically retun FragmentPosition
            else -> currentFragment = FragmentPositionPM()
        }
        return currentFragment
    }


}

