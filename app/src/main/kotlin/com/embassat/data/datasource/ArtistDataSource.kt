package com.embassat.data.datasource

import com.embassat.data.model.ArtistData

interface ArtistDataSource {
    fun requestArtists(): List<ArtistData>
    fun requestArtist(id: Long): ArtistData
}