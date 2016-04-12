package com.embassat.presentation.view

import com.embassat.presentation.entity.ArtistName

/**
 * Created by Quique on 20/05/15.
 */

interface  ArtistsView : PresentationView {
    fun showArtists(artists: List<ArtistName>)
    fun navigateToDetail(id: Long)
}