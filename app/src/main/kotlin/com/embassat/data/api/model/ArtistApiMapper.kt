package com.embassat.data.api.model

import com.embassat.data.model.ArtistData

interface ArtistApiMapper {
    fun map(source: List<ArtistApi>): List<ArtistData>
    fun map(source: ArtistApi): ArtistData
}