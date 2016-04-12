package com.embassat.domain.repository

import com.embassat.domain.entity.Artist

/**
 * Created by Quique on 20/05/15.
 */

public interface ArtistRepository {
    fun getArtists(): List<Artist>
    fun getArtist(id: Long): Artist
}