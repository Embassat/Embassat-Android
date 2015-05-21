package com.embassat.domain.interactor

import com.embassat.domain.interactor.base.Event
import com.embassat.domain.interactor.base.Interactor
import com.embassat.domain.interactor.event.ArtistEvent
import com.embassat.domain.repository.ArtistRepository

/**
 * Created by Quique on 20/05/15.
 */

class GetArtistInteractor(val artistRepository: ArtistRepository) : Interactor {

    var id: Long? = null

    override fun invoke(): Event {
        val id = this.id
        if (id == null) throw IllegalStateException("id can´t be null")

        val artist = artistRepository.getArtist(id)
        return ArtistEvent(artist)
    }
}