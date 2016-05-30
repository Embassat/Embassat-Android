package com.embassat.presentation.entity.mapper

import com.embassat.domain.entity.Artist
import com.embassat.presentation.entity.ArtistDetail
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.GregorianCalendar
import java.util.Locale

/**
 * Created by Quique on 25/5/15.
 */
class ArtistDetailMapper() {

    fun transformArtists(artists: List<Artist>): List<ArtistDetail> {
        return artists.map({
            val format = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss")
            val date = format.parse(it.start_date)
            val start_time_in_milis = date.getTime()
            val cal = GregorianCalendar()
            cal.setTime(date)
            var hour = cal.get(Calendar.HOUR_OF_DAY).toString()
            if (cal.get(Calendar.HOUR_OF_DAY) < 10) hour = "0" + hour
            var minute = cal.get(Calendar.MINUTE).toString()
            if (cal.get(Calendar.MINUTE) < 10) minute = "0" + minute
            val time = hour + ":" + minute
            val day = cal.get(Calendar.DAY_OF_WEEK)
            var dayString = ""
            when (day) {
                1 -> dayString = "Diumenge"
                5 -> dayString = "Dijous"
                6 -> dayString = "Divendres"
                7 -> dayString = "Dissabte"
            }
            val youtubeUrl = "https://www.youtube.com/watch?v="+it.youtubeViewId
            ArtistDetail(it.id, it.name, it.description, dayString, time, it.scenario, it.imageURL, it.start_date, start_time_in_milis, it.youtubeViewId, youtubeUrl)
        })
    }
}