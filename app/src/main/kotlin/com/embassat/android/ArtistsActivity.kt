package com.embassat.android

import android.graphics.Rect
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.embassat.R
import com.embassat.model.Artist
import com.embassat.model.EmbassatModel
import com.embassat.presentation.entity.ArtistName
import com.embassat.presentation.presenter.ArtistsPresenter
import com.embassat.presentation.view.ArtistsView
import rx.Observable
import java.util.ArrayList

/**
 * Created by Quique on 16/5/15.
 */

public class ArtistsActivity : BaseActivity(), ArtistsView {
    override fun navigateToDetail(id: Long) {
        throw UnsupportedOperationException()
    }

    override val layoutResource: Int = R.layout.activity_artists

    val adapter = ArtistNameAdapter()
    val presenter = ArtistsPresenter(this, observable, )
    val recycler : RecyclerView by bindView(R.id.artistsRecyclerView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super<BaseActivity>.onCreate(savedInstanceState)
        init()
    }

    fun init() {
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
}