package com.embassat.repository

import com.embassat.domain.entity.Artist
import com.embassat.domain.repository.ArtistRepository
import com.embassat.repository.dataset.ArtistDataSet

/**
 * Created by Quique on 20/05/15.
 */
class ArtistRepositoryImp(val artistDataSets: List<ArtistDataSet>) : ArtistRepository {

    override fun getArtists(): List<Artist> {
        for (dataSet in artistDataSets) {
            var result = dataSet.requestArtists()
            if (result.isNotEmpty()) {
                return result
            }
        }
        return emptyList()
    }

    override fun getArtist(id: Long): Artist {
        // TODO test if result can be null
        for (dataSet in artistDataSets) {
            var result = dataSet.requestArtist(id)
            return result;
        }
        return Artist(-1, "empty", "empty", "empty", "empty", "empty", "empty", "empty")
    }

}