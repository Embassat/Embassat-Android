package com.embassat.domain.repository

import com.embassat.domain.model.Artist

interface ArtistRepository {
    fun getArtists(): List<Artist>
    fun getArtist(id: Long): Artist
}