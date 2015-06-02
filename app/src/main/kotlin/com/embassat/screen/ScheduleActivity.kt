package com.embassat.screen

import android.support.v4.view.ViewPager
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.embassat.R
import com.embassat.adapter.ScheduleFragmentAdapter
import com.embassat.base.BaseActivity
import com.embassat.extension.bindView
import com.embassat.module.Inject
import com.embassat.module.Injector
import com.embassat.presentation.entity.ArtistSchedule
import com.embassat.presentation.view.ArtistsScheduleView


/**
 * Created by Quique on 16/5/15.
 */

public class ScheduleActivity : BaseActivity(), ArtistsScheduleView, Injector by Inject.instance {

    override fun showArtists(artists: List<ArtistSchedule>) {
        adapter.artists = artists
    }

    override val layoutResource: Int = R.layout.activity_schedule

    val viewPager : ViewPager by bindView(R.id.schedule_view_pager)
    val adapter = ScheduleFragmentAdapter(getSupportFragmentManager())

    override fun init() {
        activeTabView(0)
        viewPager.setOffscreenPageLimit(2)
        viewPager.setOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                activeTabView(position)
            }
        })
        val tabBarView = findViewById(R.id.days_header_tabbar) as ViewGroup
        for (i in 0..tabBarView.getChildCount() - 2 - 1) {
            val tabView = tabBarView.getChildAt(i * 2) as RelativeLayout
            val finalI = i
            tabView.setOnClickListener { viewPager.setCurrentItem(finalI) }
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
}