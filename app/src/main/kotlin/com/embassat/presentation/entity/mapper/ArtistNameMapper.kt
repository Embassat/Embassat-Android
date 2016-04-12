package com.embassat.presentation.entity.mapper

import com.embassat.domain.entity.Artist
import com.embassat.presentation.entity.ArtistName

/**
 * Created by Quique on 20/05/15.
 */
class ArtistNameMapper() {

    fun transformArtists(artists: List<Artist>): List<ArtistName> {
        return artists.map { ArtistName(it.id, it.name) }
    }
}