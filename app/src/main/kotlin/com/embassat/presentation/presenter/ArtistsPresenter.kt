package com.embassat.presentation.presenter

import android.os.Handler
import android.os.Looper
import com.embassat.domain.entity.Artist
import com.embassat.domain.interactor.GetArtistsInteractor
import com.embassat.domain.interactor.base.Bus
import com.embassat.domain.interactor.base.InteractorExecutor
import com.embassat.domain.interactor.event.ArtistsEvent
import com.embassat.presentation.entity.ArtistName
import com.embassat.presentation.entity.mapper.ArtistNameMapper
import com.embassat.presentation.view.ArtistsView
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread

/**
 * Created by Quique on 20/05/15.
 */
class ArtistsPresenter(
        override val view: ArtistsView,
        override val bus: Bus,
        val artistsInteractor: GetArtistsInteractor,
        val interactorExecutor: InteractorExecutor,
        val mapper: ArtistNameMapper) : GetArtistsInteractor.Callback, Presenter<ArtistsView> {

    val callback = this;

    override fun showArtistsSuccess(artists: List<Artist>) {
        Handler(Looper.getMainLooper()).post { view.showArtists(mapper.transformArtists(artists)) }
    }

    override fun onResume() {
        super.onResume()
        async() {
            val artists = artistsInteractor.getArtists()
            uiThread {
                view.showArtists(mapper.transformArtists(artists))
            }
        }
    }

    fun onArtistClicked(item: ArtistName) {
        view.navigateToDetail(item.id)
    }
}