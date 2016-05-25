package com.embassat.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.embassat.R
import com.embassat.notification.NotificationScheduler
import com.embassat.presentation.entity.ArtistSchedule

/**
 * Created by Quique on 02/06/15.
 */
class ScheduleListAdapter() : RecyclerView.Adapter<ScheduleListAdapter.MainMenuItemViewHolder>() {
    constructor(ctx: Context) : this() {
        context = ctx
    }

    var context: Context? = null
    var items: List<ArtistSchedule>? = null

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    override fun onBindViewHolder(viewHolder: MainMenuItemViewHolder, position: Int) {
        val item = items?.get(position)
        viewHolder.itemScheduleArtistNameTextView.setText(item?.name)
        viewHolder.itemScheduleHoraIniciTextView.setText(item?.start_time)
        viewHolder.itemScheduleHoraFinalTextView.setText(item?.end_time)
        viewHolder.itemScheduleEscenariTextView.setText(item?.stage)
        if (NotificationScheduler().existsNotification(context!!, item!!.id.toInt())) {
            viewHolder.background.setBackgroundColor((context as Context).resources.getColor(android.R.color.white))
        } else {
            viewHolder.background.setBackgroundColor((context as Context).resources.getColor(android.R.color.transparent))
        }
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
        val background = view.findViewById(R.id.background) as LinearLayout
    }

}