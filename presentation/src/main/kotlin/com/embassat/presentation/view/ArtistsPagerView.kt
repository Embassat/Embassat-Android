package com.embassat.presentation.view

import com.embassat.presentation.entity.ArtistDetail

/**
 * Created by Quique on 25/5/15.
 */

trait ArtistsPagerView : PresentationView {
    fun showArtists(artists: List<ArtistDetail>)
}