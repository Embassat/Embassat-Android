package com.embassat.presentation.entity.mapper

import com.embassat.domain.entity.Artist
import com.embassat.presentation.entity.ArtistSchedule
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.GregorianCalendar

/**
 * Created by Quique on 1/6/15.
 */
class ArtistScheduleMapper(position: Int) {

    val position = position;

    fun transformArtists(artists: List<Artist>, position: Int): List<ArtistSchedule> {
        return artists.map({
            val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            val cal = GregorianCalendar()

            val start_date = format.parse(it.start_date)
            cal.setTime(start_date)
            var start_hour = cal.get(Calendar.HOUR_OF_DAY).toString()
            if (cal.get(Calendar.HOUR_OF_DAY) < 10) start_hour = "0" + start_hour
            var start_minutes = cal.get(Calendar.MINUTE).toString()
            if (cal.get(Calendar.MINUTE) < 10) start_minutes = "0" + start_minutes
            val start_time = start_hour + ":" + start_minutes

            val day = cal.get(Calendar.DAY_OF_WEEK)
            var dayString = ""
            when (day) {
                1 -> {
                    if (cal.get(Calendar.HOUR_OF_DAY) < 10) dayString = "Dissabte"
                    else dayString = "Diumenge"
                }
                5 -> dayString = "Dijous"
                6 -> {
                    if (cal.get(Calendar.HOUR_OF_DAY) < 10) dayString = "Dijous"
                    else dayString = "Divendres"
                }
                7 -> {
                    if (cal.get(Calendar.HOUR_OF_DAY) < 10) dayString = "Divendres"
                    else dayString = "Dissabte"
                }
            }

            val end_date = format.parse(it.end_date)
            cal.setTime(end_date)
            var end_hour = cal.get(Calendar.HOUR_OF_DAY).toString()
            if (cal.get(Calendar.HOUR_OF_DAY) < 10) end_hour = "0" + end_hour
            var end_minutes = cal.get(Calendar.MINUTE).toString()
            if (cal.get(Calendar.MINUTE) < 10) end_minutes = "0" + end_minutes
            val end_time = end_hour + ":" + end_minutes

            ArtistSchedule(it.id, it.name, start_time, end_time, it.scenario, dayString, it.start_date)
        }).filter {
            if (position == 0)
                it.day == "Dijous"
            else if (position == 1)
                it.day == "Divendres"
            else if (position == 2)
                it.day == "Dissabte"
            else if (position == 3)
                it.day == "Diumenge"
            else false
        }.sortedBy { it.real_start_date }
    }
}