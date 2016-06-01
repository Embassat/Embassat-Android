package com.embassat.screen

import android.widget.TextView
import com.embassat.R
import com.embassat.base.BaseActivity
import com.embassat.extension.navigate

public class MainActivity : BaseActivity() {

    override val layoutResource: Int = R.layout.activity_main

    lateinit var optionInfo : TextView
    lateinit var optionArtists : TextView
    lateinit var optionSchedule : TextView
    lateinit var optionMap  : TextView
    lateinit var mapTickets : TextView
    lateinit var mapExtra : TextView
    lateinit var transportExtra : TextView

    override fun init() {
        optionInfo = findViewById(R.id.main_option_info) as TextView
        optionArtists = findViewById(R.id.main_option_artists) as TextView
        optionSchedule = findViewById(R.id.main_option_schedule) as TextView
        optionMap = findViewById(R.id.main_option_map) as TextView
        mapTickets = findViewById(R.id.main_option_tickets) as TextView
        mapExtra = findViewById(R.id.main_option_extra) as TextView
        transportExtra = findViewById(R.id.main_option_transport) as TextView
        optionInfo.setOnClickListener { navigate<InfoActivity>() }
        optionArtists.setOnClickListener { navigate<ArtistsActivity>() }
        optionSchedule.setOnClickListener { navigate<ScheduleActivity>() }
        optionMap.setOnClickListener { navigate<MapActivity>() }
        mapTickets.setOnClickListener { navigate<TicketsActivity>() }
        mapExtra.setOnClickListener { navigate<ExtraActivity>() }
        transportExtra.setOnClickListener { navigate<TransportActivity>() }
    }
}