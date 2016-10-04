package com.embassat.screen

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.embassat.R
import com.embassat.adapter.ArtistNameAdapter
import com.embassat.app.component.CloudComponent
import com.embassat.app.component.DaggerArtistsViewComponent
import com.embassat.app.component.DaggerCloudComponent
import com.embassat.app.module.CloudModule
import com.embassat.module.Inject
import com.embassat.module.Injector
import com.embassat.base.BaseActivity
import com.embassat.data.api.EmbassatService
import com.embassat.data.api.model.ArtistApi
import com.embassat.extension.navigate
import com.embassat.model.EmbassatAPI
import com.embassat.presentation.entity.ArtistName
import com.embassat.presentation.entity.mapper.ArtistNameMapper
import com.embassat.presentation.presenter.ArtistsPresenter
import com.embassat.presentation.view.ArtistsView
import retrofit.Callback
import retrofit.RestAdapter
import retrofit.RetrofitError
import retrofit.client.Response

class ArtistsActivity : BaseActivity(), ArtistsView, Injector by Inject.instance {

    override val layoutResource: Int = R.layout.activity_artists

    val adapter = ArtistNameAdapter()
    val presenter = ArtistsPresenter(this, bus, artistsInteractorProvider, interactorExecutor, ArtistNameMapper())
    lateinit var recycler : RecyclerView

    @javax.inject.Inject lateinit var restAdapter: RestAdapter

    override fun init() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbarTitle?.setText(R.string.title_activity_artists)
        adapter.onItemClickListener = { presenter.onArtistClicked(it) }
        val layoutManager = LinearLayoutManager(this)
        recycler = findViewById(R.id.artists_recycler_view) as RecyclerView
        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerArtistsViewComponent.builder().cloudComponent(DaggerCloudComponent.create()).build().inject(this)
        val service = restAdapter.create(EmbassatService::class.java)
        service.getArtists(callback = object : Callback<List<ArtistApi>>{
            override fun failure(error: RetrofitError?) {

            }

            override fun success(t: List<ArtistApi>?, response: Response?) {
                if (t != null) {
                    for (artistApi: ArtistApi in t) {
                        Log.d(artistApi.name, artistApi.description)
                    }
                }
            }

        })
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun showArtists(artists: List<ArtistName>) {
        adapter.items = artists
        adapter.notifyDataSetChanged()
    }

    override fun navigateToDetail(id: Long) {
        navigate<ArtistsPagerActivity>(id)
    }
}