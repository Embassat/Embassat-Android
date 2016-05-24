package com.embassat.adapter

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

    var onItemClickListener: ((ArtistName) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ArtistNameViewHolder? {
        val v = LayoutInflater.from(parent!!.getContext()).inflate(R.layout.item_basic_text, parent, false)
        return ArtistNameViewHolder(v, onItemClickListener)
    }

    override fun onBindViewHolder(holder: ArtistNameViewHolder?, position: Int) {
        holder?.setItem(items!![position])
        if (position == 0) holder?.setSeparatorVisibility(View.INVISIBLE)
        else holder?.setSeparatorVisibility(View.VISIBLE)
    }

    override fun getItemCount() = items?.size ?: 0
}

class ArtistNameViewHolder(view: View, var onItemClickListener: ((ArtistName) -> Unit)?) : RecyclerView.ViewHolder(view) {

    private val title = view.findViewById(R.id.itemBasicTextTextView) as TextView
    private val separator= view.findViewById(R.id.itemBasicTextSeparator)

    fun setItem(item: ArtistName) {
        itemView?.setOnClickListener { onItemClickListener?.invoke(item) }
        title.text = item.name
    }

    fun setSeparatorVisibility(visibility: Int) {
        separator.setVisibility(visibility)
    }
}