package com.embassat.presentation.presenter

import com.embassat.domain.interactor.GetArtistsInteractor
import com.embassat.domain.interactor.base.Bus
import com.embassat.domain.interactor.base.InteractorExecutor
import com.embassat.domain.interactor.event.ArtistsEvent
import com.embassat.presentation.entity.mapper.ArtistScheduleMapper
import com.embassat.presentation.view.ArtistsPagerView
import com.embassat.presentation.view.ArtistsScheduleView
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread

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
        async() {
            val artists = artistsInteractor.getArtists()
            uiThread {
                view.showArtists(mapper.transformArtists(artists, mapper.position))
            }
        }
    }
}