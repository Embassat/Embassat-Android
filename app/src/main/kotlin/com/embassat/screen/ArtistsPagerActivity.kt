package com.embassat.screen

import android.graphics.PorterDuff
import android.support.v4.view.ViewPager
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.embassat.R
import com.embassat.adapter.ArtistsPagerFragmentAdapter
import com.embassat.base.BaseActivity
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

class ArtistsPagerActivity : BaseActivity(), ArtistsPagerView, ViewPager.OnPageChangeListener, Injector by Inject.instance {

    override val layoutResource: Int = R.layout.activity_artists_pager

    val viewPager = findViewById(R.id.artists_pager_view_pager) as ViewPager

    val adapter = ArtistsPagerFragmentAdapter(supportFragmentManager)
    val presenter = ArtistsPagerPresenter(this, bus, artistsInteractorProvider, interactorExecutor, ArtistDetailMapper())
    var id : Long = 0
    var currentPosition = 0
    var menuItem : MenuItem? = null

    override fun init() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        id = intent.extras.getLong("ID")
        toolbarTitle?.setText(R.string.title_activity_artists)
        viewPager.setOffscreenPageLimit(2)
        viewPager.setAdapter(adapter)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onCreateOptionsMenu(menu: Menu) : Boolean {
        super.onPrepareOptionsMenu(menu)
        MenuInflater(this).inflate(R.menu.artist_detail, menu)

        menuItem = menu.findItem(R.id.fav_option)

        if (NotificationScheduler().existsNotification(this, id.toInt()))
            menuItem?.getIcon()?.setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.MULTIPLY)
        else
            menuItem?.getIcon()?.setColorFilter(getResources().getColor(R.color.background), PorterDuff.Mode.MULTIPLY)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) : Boolean {
        when (item.getItemId()) {
            R.id.fav_option -> {
                addNotification(id)
                return true
            }
        }
        return super<BaseActivity>.onOptionsItemSelected(item)
    }

    override fun showArtists(artists: List<ArtistDetail>) {
        adapter.items = artists
        currentPosition = adapter.getItemPositionById(id)
        viewPager.setOnPageChangeListener(this)
        viewPager.setCurrentItem(currentPosition)

    }

    override fun addNotification(id: Long) {
        val position = adapter.getItemPositionById(id)
        if (position == -1) return
        NotificationScheduler().toggleNotification(this, id.toInt(), adapter.items?.get(position)?.real_time_in_milis ?: 0 - (1000 * 60 * 15), adapter.items?.get(position)?.name)
        if (NotificationScheduler().existsNotification(this, id.toInt()))
            menuItem?.getIcon()?.setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.MULTIPLY)
        else
            menuItem?.getIcon()?.setColorFilter(getResources().getColor(R.color.background), PorterDuff.Mode.MULTIPLY)
    }

    override fun onPageSelected(position: Int) {
        id = adapter.items?.get(position)?.id ?: 0
        invalidateOptionsMenu()
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }
}