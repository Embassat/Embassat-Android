package com.embassat.data

import com.embassat.data.api.EmbassatService
import com.embassat.data.api.model.ArtistApiMapper
import com.embassat.domain.entity.Artist

 class CloudArtistDataSource(val language: String, val embassatService: EmbassatService) : ArtistDataSource {
    override fun requestArtist(id: Long): Artist {
        val result = embassatService.getArtist(id)
        return ArtistApiMapper().transform(result)
    }

    override fun requestArtists(): List<Artist> {
        val result = embassatService.getArtists()
        return ArtistApiMapper().transform(result)
    }
}