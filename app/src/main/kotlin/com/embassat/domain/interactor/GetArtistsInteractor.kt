package com.embassat.domain.interactor

import android.os.Handler
import com.embassat.domain.entity.Artist
import com.embassat.domain.interactor.base.Event
import com.embassat.domain.interactor.base.Interactor
import com.embassat.domain.interactor.event.ArtistsEvent
import com.embassat.domain.repository.ArtistRepository
import com.embassat.presentation.presenter.ArtistsPresenter

/**
 * Created by Quique on 20/05/15.
 */

class GetArtistsInteractor(val artistRepository: ArtistRepository) : Interactor {

    override fun invoke(): Event {
        val artists = artistRepository.getArtists()
        return ArtistsEvent(artists)
    }

    public interface Callback {
        fun showArtistsSuccess(artists: List<Artist>)
    }

    fun getArtists(): List<Artist> {
        val artists = artistRepository.getArtists()
        return artists
    }
}