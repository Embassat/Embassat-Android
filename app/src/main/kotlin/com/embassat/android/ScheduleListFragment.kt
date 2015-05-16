package com.embassat.android

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.embassat.R
import com.embassat.model.Artist
import com.embassat.model.EmbassatAPI
import rx.Observable
import java.util.ArrayList

/**
 * Created by Quique on 16/5/15.
 */

public class ScheduleListFragment : Fragment() {

    private val EXTRA_POSITION = "extra_position"

    private var position: Int = 0

    var artistsRecyclerView: RecyclerView? = null
    val artists: MutableList<Artist> = ArrayList()
    val mainMenuAdapter: ScheduleListAdapter = ScheduleListAdapter(artists)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        position = getArguments().getInt(EXTRA_POSITION)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_schedule_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpScheduledArtists()
    }

    private fun setUpScheduledArtists() {
        artistsRecyclerView = getView().findViewById(R.id.scheduleListRecyclerView) as RecyclerView
        val layoutManager = LinearLayoutManager(getActivity())
        artistsRecyclerView?.setLayoutManager(layoutManager)
        artistsRecyclerView?.setAdapter(mainMenuAdapter)
        val artistsObservable: Observable<List<Artist>> = EmbassatAPI().getArtists()
        artistsObservable.subscribe{result -> setDayArtists(result)}
    }

    private fun setDayArtists(newArtists: List<Artist>) {
        for (artist in newArtists) {
            when (position) {
                0 -> if ("DIJ".equals(artist.date)) artists.add(artist)
                1 -> if ("DIV".equals(artist.date)) artists.add(artist)
                2 -> if ("DIS".equals(artist.date)) artists.add(artist)
            }
        }
        mainMenuAdapter.notifyDataSetChanged()
    }

    inner class ScheduleListAdapter(items: List<Artist>) : RecyclerView.Adapter<ScheduleListAdapter.MainMenuItemViewHolder>() {

        val items: List<Artist> = items

        override fun getItemCount(): Int {
            return items.size()
        }

        override fun onBindViewHolder(viewHolder: MainMenuItemViewHolder, position: Int) {
            val item = items[position]
            viewHolder.itemScheduleArtistNameTextView.setText(item.title)
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainMenuItemViewHolder? {
            val view = LayoutInflater.from(parent?.getContext()).inflate(R.layout.item_schedule, parent, false)
            return MainMenuItemViewHolder(view);
        }

        inner class MainMenuItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val itemScheduleHoraIniciTextView = view.findViewById(R.id.hora_inici_text_view) as TextView
            val itemScheduleHoraFinalTextView = view.findViewById(R.id.hora_final_text_view) as TextView
            val itemScheduleArtistNameTextView = view.findViewById(R.id.artist_name_text_view) as TextView
            val itemScheduleEscenariTextView = view.findViewById(R.id.escenari_text_view) as TextView
        }

    }
}
