package com.embassat.screen

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.embassat.R
import com.embassat.adapter.ScheduleListAdapter
import com.embassat.module.Inject
import com.embassat.module.Injector
import com.embassat.presentation.entity.ArtistSchedule
import com.embassat.presentation.entity.mapper.ArtistScheduleMapper
import com.embassat.presentation.presenter.ArtistsSchedulePresenter
import com.embassat.presentation.view.ArtistsScheduleView

/**
 * Created by Quique on 16/5/15.
 */

public class ScheduleListFragment : Fragment(), ArtistsScheduleView, Injector by Inject.instance {

    private val EXTRA_POSITION = "extra_position"

    val adapter: ScheduleListAdapter = ScheduleListAdapter()
    var presenter : ArtistsSchedulePresenter? = null
    var position : Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super<Fragment>.onCreate(savedInstanceState)
        position = getArguments().getInt(EXTRA_POSITION)
        presenter = ArtistsSchedulePresenter(this, bus, artistsInteractorProvider, interactorExecutor, ArtistScheduleMapper(position))
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_schedule_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var artistsRecyclerView = view.findViewById(R.id.scheduleListRecyclerView) as RecyclerView;
        artistsRecyclerView.layoutManager = LinearLayoutManager(getActivity())
        artistsRecyclerView.adapter = adapter
    }

    override fun onResume() {
        super<Fragment>.onResume()
        presenter?.onResume()
    }

    override fun onPause() {
        super<Fragment>.onPause()
        presenter?.onPause()
    }

    override fun showArtists(artists: List<ArtistSchedule>) {
        adapter.items = artists
    }
}