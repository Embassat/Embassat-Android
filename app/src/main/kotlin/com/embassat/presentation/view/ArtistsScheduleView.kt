package com.embassat.presentation.view

import com.embassat.presentation.entity.ArtistSchedule

/**
 * Created by Quique on 1/6/15.
 */
interface  ArtistsScheduleView : PresentationView {
    fun showArtists(artists: List<ArtistSchedule>)
}