package com.embassat.screen

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.embassat.R
import com.embassat.presentation.entity.ArtistDetail

/**
 * Created by Quique on 1/6/15.
 */

class ArtistDetailFragment : Fragment() {

    private val EXTRA_ARTIST = "artist"

    private var artist: ArtistDetail? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        artist = getArguments().getSerializable(EXTRA_ARTIST) as ArtistDetail?
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_artist_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (view.findViewById(R.id.artist_detail_fragment_day) as TextView).setText(artist?.day)
        (view.findViewById(R.id.artist_detail_fragment_hour) as TextView).setText(artist?.time)
        (view.findViewById(R.id.artist_detail_fragment_stage) as TextView).setText(artist?.stage)
        (view.findViewById(R.id.artist_detail_fragment_name) as TextView).setText(artist?.name)
        (view.findViewById(R.id.artist_detail_fragment_description) as TextView).setText(artist?.description)
        Glide.with(activity).load(artist?.imageURL).into(view.findViewById(R.id.artist_detail_fragment_image) as ImageView)
        (view.findViewById(R.id.youtube_button) as ImageButton).setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://" + artist?.youtubeID))
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            }
            catch (e: ActivityNotFoundException) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(artist?.youtubeURL))
                startActivity(intent)
            }
        }
    }
}