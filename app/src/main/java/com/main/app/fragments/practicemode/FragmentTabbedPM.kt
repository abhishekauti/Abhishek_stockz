package com.main.app.fragments.practicemode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.main.app.R


class FragmentTabbedPM : Fragment() {
    lateinit var viewPager: ViewPager2
    lateinit var tabLayout: TabLayout



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_tabbed_p_m, container, false)

        viewPager = view.findViewById(R.id.pmViewPager)
        tabLayout = view.findViewById(R.id.pmTabLayout)


        val adapter = PMViewPagerAdapter(requireActivity().supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab,
                                                  position ->
            when (position) {
                0 -> tab.text = "Position"
                1 -> tab.text = "Portfolio"
            }
        }.attach()
        return view

    }
}

class PMViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

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

