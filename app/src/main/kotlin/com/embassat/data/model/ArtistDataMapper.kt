package com.embassat.data.model

import com.embassat.domain.model.Artist

interface ArtistDataMapper {
    fun map(source: List<ArtistData>): List<Artist>
    fun map(source: ArtistData): Artist
}