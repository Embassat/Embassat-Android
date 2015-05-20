package com.embassat.domain.interactor

import com.embassat.domain.interactor.base.Event
import com.embassat.domain.interactor.base.Interactor
import com.embassat.domain.interactor.event.ArtistsEvent
import com.embassat.domain.repository.ArtistRepository

/**
 * Created by Quique on 20/05/15.
 */

class GetArtistsInteractor(val artistRepository: ArtistRepository) : Interactor {

    override fun invoke(): Event {
        val artists = artistRepository.getArtists()
        return ArtistsEvent(artists)
    }
}