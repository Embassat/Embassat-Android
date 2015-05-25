package com.embassat.presentation.presenter

import com.embassat.domain.interactor.GetArtistsInteractor
import com.embassat.domain.interactor.base.Bus
import com.embassat.domain.interactor.base.InteractorExecutor
import com.embassat.domain.interactor.event.ArtistsEvent
import com.embassat.presentation.entity.mapper.ArtistDetailMapper
import com.embassat.presentation.view.ArtistsPagerView

/**
 * Created by Quique on 25/5/15.
 */

class ArtistsPagerPresenter(
        override val view: ArtistsPagerView,
        override val bus: Bus,
        val artistsInteractor: GetArtistsInteractor,
        val interactorExecutor: InteractorExecutor,
        val mapper: ArtistDetailMapper) : Presenter<ArtistsPagerView> {

    override fun onResume() {
        super.onResume()
        interactorExecutor.execute(artistsInteractor)
    }

    fun onEvent(event: ArtistsEvent) {
        view.showArtists(mapper.transformArtists(event.artists))
    }
}