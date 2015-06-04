package com.embassat.adapter

import android.opengl.Visibility
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.embassat.R
import com.embassat.notification.NotificationScheduler
import com.embassat.presentation.entity.ArtistSchedule

/**
 * Created by Quique on 02/06/15.
 */
class ScheduleListAdapter() : RecyclerView.Adapter<ScheduleListAdapter.MainMenuItemViewHolder>() {

    var items: List<ArtistSchedule>? = null
        set(value) {
            $items = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int {
        return items?.size() ?: 0
    }

    override fun onBindViewHolder(viewHolder: MainMenuItemViewHolder, position: Int) {
        val item = items?.get(position)
        viewHolder.itemScheduleArtistNameTextView.setText(item?.name)
        viewHolder.itemScheduleHoraIniciTextView.setText(item?.start_time)
        viewHolder.itemScheduleHoraFinalTextView.setText(item?.end_time)
        viewHolder.itemScheduleEscenariTextView.setText(item?.stage)
        //viewHolder.itemScheduleStarTextView.setVisibility(NotificationScheduler.containsId(item?.id) ? View.VISIBLE : View.GONE)
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
        //val itemScheduleStarTextView = view.findViewById(R.id.star_image_view)
    }

}