package com.embassat.presentation.presenter

import com.embassat.domain.interactor.GetArtistsInteractor
import com.embassat.domain.interactor.base.Bus
import com.embassat.domain.interactor.base.InteractorExecutor
import com.embassat.domain.interactor.event.ArtistsEvent
import com.embassat.presentation.entity.mapper.ArtistScheduleMapper
import com.embassat.presentation.view.ArtistsPagerView
import com.embassat.presentation.view.ArtistsScheduleView

/**
 * Created by Quique on 1/6/15.
 */


class ArtistsSchedulePresenter(
        override val view: ArtistsScheduleView,
        override val bus: Bus,
        val artistsInteractor: GetArtistsInteractor,
        val interactorExecutor: InteractorExecutor,
        val mapper: ArtistScheduleMapper) : Presenter<ArtistsScheduleView> {

    override fun onResume() {
        super.onResume()
        interactorExecutor.execute(artistsInteractor)
    }

    fun onEvent(event: ArtistsEvent) {
        view.showArtists(mapper.transformArtists(event.artists))
    }
}