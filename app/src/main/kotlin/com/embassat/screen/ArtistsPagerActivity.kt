package com.embassat.screen

import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import com.embassat.R
import com.embassat.adapter.ArtistsPagerFragmentAdapter
import com.embassat.base.BaseActivity
import com.embassat.extension.bindView
import com.embassat.module.Inject
import com.embassat.module.Injector
import com.embassat.notification.NotificationScheduler
import com.embassat.presentation.entity.ArtistDetail
import com.embassat.presentation.entity.mapper.ArtistDetailMapper
import com.embassat.presentation.presenter.ArtistsPagerPresenter
import com.embassat.presentation.view.ArtistsPagerView

/**
 * Created by Quique on 25/5/15.
 */

public class ArtistsPagerActivity : BaseActivity(), ArtistsPagerView, Injector by Inject.instance {

    override val layoutResource: Int = R.layout.activity_artists_pager

    val viewPager : ViewPager by bindView(R.id.artists_pager_view_pager)

    val adapter = ArtistsPagerFragmentAdapter(getSupportFragmentManager())
    val presenter = ArtistsPagerPresenter(this, bus, artistsInteractorProvider, interactorExecutor, ArtistDetailMapper())
    var id : Long = 0
    var currentPosition = 0

    override fun init() {
        setSupportActionBar(toolbar)
        getSupportActionBar().setDisplayShowTitleEnabled(false)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true)
        id = getIntent().getExtras().getLong("ID")
        toolbarTitle.setText(R.string.title_activity_artists)
        viewPager.setOffscreenPageLimit(2)
        viewPager.setAdapter(adapter)
    }

    override fun onResume() {
        super<BaseActivity>.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super<BaseActivity>.onPause()
        presenter.onPause()
    }

    override fun showArtists(artists: List<ArtistDetail>) {
        adapter.items = artists
        currentPosition = adapter.getItemPositionById(id)
        viewPager.setCurrentItem(currentPosition)
    }

    override fun addNotification(id: Long) {
        val position = adapter.getItemPositionById(id)
        if (position == -1) return
        NotificationScheduler.add(id, adapter.items?.get(position)?.name, adapter.items?.get(position)?.stage, adapter.items?.get(position)?.real_start_date)
    }
}