package com.embassat.screen

import android.widget.TextView
import com.embassat.R
import com.embassat.base.BaseActivity
import com.embassat.extension.bindView
import com.embassat.extension.navigate

public class MainActivity : BaseActivity() {

    override val layoutResource: Int = R.layout.activity_main

    val optionInfo : TextView by bindView(R.id.main_option_info)
    val optionArtists : TextView by bindView(R.id.main_option_artists)
    val optionSchedule : TextView by bindView(R.id.main_option_schedule)
    val optionMap : TextView by bindView(R.id.main_option_map)
    val mapTickets : TextView by bindView(R.id.main_option_tickets)
    val mapExtra : TextView by bindView(R.id.main_option_extra)

    override fun init() {
        optionInfo.setOnClickListener { navigate<InfoActivity>() }
        optionArtists.setOnClickListener { navigate<ArtistsActivity>() }
        optionSchedule.setOnClickListener { navigate<ScheduleActivity>() }
        optionMap.setOnClickListener {
            //TODO map activity
        }
        mapTickets.setOnClickListener { navigate<TicketsActivity>() }
        mapExtra.setOnClickListener { navigate<ExtraActivity>() }
    }
}