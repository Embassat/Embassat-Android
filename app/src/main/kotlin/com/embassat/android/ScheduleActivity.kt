package com.embassat.android

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.embassat.R

/**
 * Created by Quique on 16/5/15.
 */

public class ScheduleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)
        setUpSchedule()
    }

    private fun setUpSchedule() {
        activeTabView(0)
        val viewPager = findViewById(R.id.schedule_list_view_pager) as ViewPager
        viewPager.setOffscreenPageLimit(2)
        viewPager.setAdapter(ScheduleListFragmentAdapter(getSupportFragmentManager()))
        viewPager.setOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                activeTabView(position)
            }
        })
        val tabBarView = findViewById(R.id.days_header_tabbar) as ViewGroup
        for (i in 0..tabBarView.getChildCount() - 2 - 1) {
            val tabView = tabBarView.getChildAt(i * 2) as RelativeLayout
            val finalI = i
            tabView.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View) {
                    viewPager.setCurrentItem(finalI)
                }
            })
        }
    }

    private fun activeTabView(position: Int) {
        val tabBarView = findViewById(R.id.days_header_tabbar) as ViewGroup
        for (i in 0..tabBarView.getChildCount() - 2 - 1) {
            val tabView = tabBarView.getChildAt(i * 2) as RelativeLayout
            tabView.setBackgroundColor(if (i == position) getResources().getColor(android.R.color.black) else getResources().getColor(android.R.color.white))
            val tabTextView = tabView.getChildAt(0) as TextView
            tabTextView.setTextColor(if (i == position) getResources().getColor(android.R.color.white) else getResources().getColor(android.R.color.black))
        }
    }

    inner class ScheduleListFragmentAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        override fun getCount(): Int {
            return 3
        }

        override fun getItem(position: Int): Fragment {
            val fragment = ScheduleListFragment()

            val args = Bundle()
            args.putInt("extra_position", position)
            fragment.setArguments(args)

            return fragment
        }
    }
}
