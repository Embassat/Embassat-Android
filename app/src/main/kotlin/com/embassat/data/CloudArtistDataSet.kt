package com.embassat.data

import com.embassat.data.mapper.ArtistMapper
import com.embassat.domain.entity.Artist
import com.embassat.data.embassat.EmbassatService
import com.embassat.repository.dataset.ArtistDataSet

/**
 * Created by Quique on 20/05/15.
 */
 class CloudArtistDataSet(val language: String, val embassatService: EmbassatService) : ArtistDataSet {

    override fun requestArtist(id: Long): Artist {
        val result = embassatService.getArtist(id)
        return ArtistMapper().transform(result)
    }

    override fun requestArtists(): List<Artist> {
        val result = embassatService.getArtists()
        return ArtistMapper().transform(result)
    }
}