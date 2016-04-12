package com.embassat.screen

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.embassat.R
import com.embassat.adapter.ArtistNameAdapter
import com.embassat.module.Inject
import com.embassat.module.Injector
import com.embassat.base.BaseActivity
import com.embassat.extension.navigate
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
    val recycler = findViewById(R.id.artists_recycler_view) as RecyclerView

    override fun init() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbarTitle.setText(R.string.title_activity_artists)
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
        navigate<ArtistsPagerActivity>(id)
    }
}