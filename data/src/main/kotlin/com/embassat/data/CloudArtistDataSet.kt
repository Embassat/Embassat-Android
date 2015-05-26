package com.embassat.data

import com.embassat.data.mapper.ArtistMapper
import com.embassat.domain.entity.Artist
import com.embassat.model.EmbassatService
import com.embassat.repository.dataset.ArtistDataSet
import com.firebase.client.Firebase

/**
 * Created by Quique on 20/05/15.
 */
public class CloudArtistDataSet(val language: String, val embassatService: EmbassatService, val firebaseReference: Firebase) : ArtistDataSet {

    override fun requestArtist(id: Long): Artist {

        val result = embassatService.getArtist(id)
        firebaseReference.child("artist").get
        return ArtistMapper().transform(result)
    }

    override fun requestArtists(): List<Artist> {
        val result = embassatService.getArtists()
        return ArtistMapper().transform(result)
    }
}