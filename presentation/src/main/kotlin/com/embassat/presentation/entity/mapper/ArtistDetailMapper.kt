package com.embassat.presentation.entity.mapper

import com.embassat.domain.entity.Artist
import com.embassat.presentation.entity.ArtistDetail

/**
 * Created by Quique on 25/5/15.
 */
class ArtistDetailMapper() {

    fun transformArtists(artists: List<Artist>): List<ArtistDetail> {
        return artists.map { ArtistDetail(it.id, it.name, it.description, it.date, it.time, it.scenario) }
    }
}