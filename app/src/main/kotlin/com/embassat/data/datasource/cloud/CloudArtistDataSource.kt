package com.embassat.data.datasource.cloud

import com.embassat.data.api.model.ArtistApiMapper
import com.embassat.data.api.retrofit.EmbassatService
import com.embassat.data.datasource.ArtistDataSource
import com.embassat.data.model.ArtistData
import javax.inject.Inject

class CloudArtistDataSource @Inject constructor(val embassatService: EmbassatService, val artistApiMapper: ArtistApiMapper) : ArtistDataSource {
    override fun requestArtist(id: Long): ArtistData {
        val result = embassatService.getArtist(id)
        return artistApiMapper.map(result)
    }

    override fun requestArtists(): List<ArtistData> {
        val result = embassatService.getArtists()
        return artistApiMapper.map(result)
    }
}