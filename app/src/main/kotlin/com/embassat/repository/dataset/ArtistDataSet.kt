package com.embassat.repository.dataset

import com.embassat.domain.entity.Artist

/**
 * Created by Quique on 20/05/15.
 */

public interface ArtistDataSet {

    fun requestArtists(): List<Artist>
    fun requestArtist(id: Long): Artist
}