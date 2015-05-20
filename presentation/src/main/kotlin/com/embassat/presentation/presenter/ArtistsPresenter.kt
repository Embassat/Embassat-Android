package com.embassat.presentation.presenter

import com.embassat.domain.interactor.GetArtistsInteractor
import com.embassat.domain.interactor.base.Bus
import com.embassat.domain.interactor.base.InteractorExecutor
import com.embassat.domain.interactor.event.ArtistsEvent
import com.embassat.presentation.entity.ArtistName
import com.embassat.presentation.entity.mapper.ArtistNameMapper
import com.embassat.presentation.view.ArtistsView

/**
 * Created by Quique on 20/05/15.
 */
class ArtistsPresenter(
        override val view: ArtistsView,
        override val bus: Bus,
        val artistsInteractor: GetArtistsInteractor,
        val interactorExecutor: InteractorExecutor,
        val mapper: ArtistNameMapper) : Presenter<ArtistsView> {

    override fun onResume() {
        super.onResume()
        interactorExecutor.execute(artistsInteractor)
    }

    fun onEvent(event: ArtistsEvent) {
        view.showArtists(mapper.transformArtists(event.artists))
    }

    fun onArtistClicked(item: ArtistName) {
        view.navigateToDetail(item.id)
    }
}