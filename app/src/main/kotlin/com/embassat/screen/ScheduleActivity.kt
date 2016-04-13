package com.embassat.screen

import android.support.v4.view.ViewPager
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.embassat.R
import com.embassat.adapter.ScheduleFragmentAdapter
import com.embassat.base.BaseActivity

/**
 * Created by Quique on 16/5/15.
 */

public class ScheduleActivity : BaseActivity() {

    override val layoutResource: Int = R.layout.activity_schedule

    lateinit var viewPager : ViewPager
    val adapter = ScheduleFragmentAdapter(supportFragmentManager)

    override fun init() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbarTitle?.setText(R.string.title_activity_horaris)
        activeTabView(0)
        viewPager = findViewById(R.id.schedule_view_pager) as ViewPager
        viewPager.offscreenPageLimit = 2
        viewPager.setOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                activeTabView(position)
            }
        })
        viewPager.adapter = adapter
        val tabBarView = findViewById(R.id.days_header_tabbar) as ViewGroup
        for (i in 0..tabBarView.childCount -1) {
            val tabView = tabBarView.getChildAt(i) as RelativeLayout
            val finalI = i
            tabView.setOnClickListener { viewPager.setCurrentItem(finalI) }
        }
    }

    private fun activeTabView(position: Int) {
        val tabBarView = findViewById(R.id.days_header_tabbar) as ViewGroup
        for (i in 0..tabBarView.childCount -1) {
            val tabView = tabBarView.getChildAt(i) as RelativeLayout
            tabView.setBackgroundColor(if (i == position) resources.getColor(R.color.tab_background_selected) else resources.getColor(R.color.tab_background))
            val tabTextView = tabView.getChildAt(0) as TextView
            tabTextView.setTextColor(if (i == position) resources.getColor(android.R.color.white) else resources.getColor(R.color.primary))
        }
    }
}