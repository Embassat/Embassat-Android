package com.embassat.screen

import android.widget.TextView
import com.embassat.R
import com.embassat.base.BaseActivity
import com.embassat.extension.navigate

public class MainActivity : BaseActivity() {

    override val layoutResource: Int = R.layout.activity_main

    val optionInfo = findViewById(R.id.main_option_info) as TextView
    val optionArtists = findViewById(R.id.main_option_artists) as TextView
    val optionSchedule = findViewById(R.id.main_option_schedule) as TextView
    val optionMap = findViewById(R.id.main_option_map) as TextView
    val mapTickets = findViewById(R.id.main_option_tickets) as TextView
    val mapExtra = findViewById(R.id.main_option_extra) as TextView

    override fun init() {
        optionInfo.setOnClickListener { navigate<InfoActivity>() }
        optionArtists.setOnClickListener { navigate<ArtistsActivity>() }
        optionSchedule.setOnClickListener { navigate<ScheduleActivity>() }
        optionMap.setOnClickListener { navigate<MapActivity>() }
        mapTickets.setOnClickListener { navigate<TicketsActivity>() }
        mapExtra.setOnClickListener { navigate<ExtraActivity>() }
    }
}