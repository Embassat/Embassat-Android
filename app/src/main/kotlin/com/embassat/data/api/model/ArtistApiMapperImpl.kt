package com.embassat.data.api.model

import com.embassat.data.model.ArtistData
import javax.inject.Inject

class ArtistApiMapperImpl @Inject constructor(): ArtistApiMapper{
    override fun map(source: List<ArtistApi>): List<ArtistData> = source.map { map(it) }
    override fun map(source: ArtistApi): ArtistData = ArtistData(source.id)
}