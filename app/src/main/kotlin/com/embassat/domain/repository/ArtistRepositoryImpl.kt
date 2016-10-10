package com.embassat.domain.repository

import com.embassat.data.datasource.ArtistDataSource
import com.embassat.data.model.ArtistDataMapper
import com.embassat.domain.model.Artist
import javax.inject.Inject

class ArtistRepositoryImpl @Inject constructor(val artistDataSource: ArtistDataSource, val artistDataMapper: ArtistDataMapper): ArtistRepository {
    override fun getArtists(): List<Artist> {
        val result = artistDataSource.requestArtists()
        return artistDataMapper.map(result)
    }

    override fun getArtist(id: Long): Artist {
        val result = artistDataSource.requestArtist(id)
        return artistDataMapper.map(result)
    }
}