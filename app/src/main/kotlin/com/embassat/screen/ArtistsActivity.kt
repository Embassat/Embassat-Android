package com.embassat.screen

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.embassat.R
import com.embassat.adapter.ArtistNameAdapter
import com.embassat.module.Inject
import com.embassat.module.Injector
import com.embassat.extension.bindView
import com.embassat.base.BaseActivity
import com.embassat.presentation.entity.ArtistName
import com.embassat.presentation.entity.mapper.ArtistNameMapper
import com.embassat.presentation.presenter.ArtistsPresenter
import com.embassat.presentation.view.ArtistsView

/**
 * Created by Quique on 16/5/15.
 */

public class ArtistsActivity : BaseActivity(), ArtistsView, Injector by Inject.instance {

    override val layoutResource: Int = R.layout.activity_artists

    val adapter = ArtistNameAdapter()
    val presenter = ArtistsPresenter(this, bus, artistsInteractorProvider, interactorExecutor, ArtistNameMapper())
    val recycler : RecyclerView by bindView(R.id.artists_recycler_view)

    override fun init() {
        setSupportActionBar(toolbar)
        adapter.onItemClickListener = { presenter.onArtistClicked(it) }
        val layoutManager = LinearLayoutManager(this)
        recycler.setLayoutManager(layoutManager)
        recycler.setAdapter(adapter)
    }

    override fun onResume() {
        super<BaseActivity>.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super<BaseActivity>.onPause()
        presenter.onPause()
    }

    override fun showArtists(artists: List<ArtistName>) {
        adapter.items = artists
    }

    override fun navigateToDetail(id: Long) {
        //TODO go to
    }
}