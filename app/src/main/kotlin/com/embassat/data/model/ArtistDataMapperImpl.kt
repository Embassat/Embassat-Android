package com.embassat.data.model

import com.embassat.domain.model.Artist
import javax.inject.Inject

class ArtistDataMapperImpl @Inject constructor(): ArtistDataMapper {
    override fun map(source: List<ArtistData>): List<Artist> = source.map { map(it) }

    override fun map(source: ArtistData): Artist = Artist(source.id)
}