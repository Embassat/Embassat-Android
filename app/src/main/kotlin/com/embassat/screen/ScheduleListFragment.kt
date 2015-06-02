package com.embassat.screen

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
import com.embassat.model.EmbassatModel
import rx.Observable
import java.util.ArrayList

/**
 * Created by Quique on 16/5/15.
 */

public class ScheduleListFragment : Fragment() {

    private val EXTRA_ARTISTS = "extra_artists"

    var artistsRecyclerView: RecyclerView? = null
    val mainMenuAdapter: ScheduleListAdapter = ScheduleListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        artistsRecyclerView = getView().findViewById(R.id.scheduleListRecyclerView) as RecyclerView
        val layoutManager = LinearLayoutManager(getActivity())
        artistsRecyclerView?.setLayoutManager(layoutManager)
        artistsRecyclerView?.setAdapter(mainMenuAdapter)
        mainMenuAdapter.items = getArguments().getSerializable(EXTRA_ARTISTS) as List<Artist>
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_schedule_list, container, false)
    }

    inner class ScheduleListAdapter() : RecyclerView.Adapter<ScheduleListAdapter.MainMenuItemViewHolder>() {

        var items: List<Artist>? = null
            set(value) {
                $items = value
                notifyDataSetChanged()
            }

        override fun getItemCount(): Int {
            return items?.size() ?: 0
        }

        override fun onBindViewHolder(viewHolder: MainMenuItemViewHolder, position: Int) {
            val item = items?.get(position)
            viewHolder.itemScheduleArtistNameTextView.setText(item?.title)
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