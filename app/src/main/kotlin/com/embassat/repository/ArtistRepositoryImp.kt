package com.embassat.repository

import com.embassat.domain.entity.Artist
import com.embassat.domain.repository.ArtistRepository
import com.embassat.data.datasource.ArtistDataSource

/**
 * Created by Quique on 20/05/15.
 */
class ArtistRepositoryImp(val artistDataSources: List<ArtistDataSource>) : ArtistRepository {

    override fun getArtists(): List<Artist> {
        for (dataSet in artistDataSources) {
            var result = dataSet.requestArtists()
            if (result.isNotEmpty()) {
                return result
            }
        }
        return emptyList()
    }

    override fun getArtist(id: Long): Artist {
        // TODO test if result can be null
        for (dataSet in artistDataSources) {
            var result = dataSet.requestArtist(id)
            return result;
        }
        return Artist(-1, "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty")
    }

}