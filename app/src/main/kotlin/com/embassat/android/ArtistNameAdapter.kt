package com.embassat.android

import android.support.v4.view.LayoutInflaterCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.embassat.R
import com.embassat.presentation.entity.ArtistName

/**
 * Created by Quique on 20/05/15.
 */

class ArtistNameAdapter() : RecyclerView.Adapter<ArtistNameViewHolder>() {

    var items: List<ArtistName>? = null
        set(value) {
            $items = value
            notifyDataSetChanged()
        }

    var onItemClickListener: ((ArtistName) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ArtistNameViewHolder? {
        val v = LayoutInflater.from(parent!!.getContext()).inflate(R.layout.item_basic_text, parent, false)
        return ArtistNameViewHolder(v, onItemClickListener)
    }

    override fun onBindViewHolder(holder: ArtistNameViewHolder?, position: Int) {
        holder?.setItem(items!![position])
    }

    override fun getItemCount() = items?.size() ?: 0
}

private class ArtistNameViewHolder(view: View, var onItemClickListener: ((ArtistName) -> Unit)?) : RecyclerView.ViewHolder(view) {

    private val title: TextView by bindView(R.id.itemBasicTextTextView)

    fun setItem(item: ArtistName) {
        itemView?.setOnClickListener { onItemClickListener?.invoke(item) }
        title.setText(item.name)
    }
}