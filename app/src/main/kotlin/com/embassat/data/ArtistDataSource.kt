package com.embassat.data

import com.embassat.domain.entity.Artist

interface ArtistDataSource {
    fun requestArtists(): List<Artist>
    fun requestArtist(id: Long): Artist
}