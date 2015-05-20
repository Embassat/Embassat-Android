package com.embassat.data

import com.embassat.data.mapper.ArtistMapper
import com.embassat.domain.entity.Artist
import com.embassat.model.EmbassatService
import com.embassat.repository.dataset.ArtistDataSet

/**
 * Created by Quique on 20/05/15.
 */
public class CloudArtistDataSet(val language: String, val embassatService: EmbassatService) : ArtistDataSet {

    override fun requestArtist(id: Long): Artist {
        val result = embassatService.getArtist(id)
        return ArtistMapper().transform(result)
    }

    override fun requestArtists(): List<Artist> {
        // Search for coldplay similar artists.
        val result = embassatService.getArtists()
        return ArtistMapper().transform(result)
    }
}