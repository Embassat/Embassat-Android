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
import com.embassat.model.EmbassatAPI
import com.embassat.model.EmbassatModel
import rx.Observable
import java.util.ArrayList

/**
 * Created by Quique on 16/5/15.
 */

public class ArtistsActivity : AppCompatActivity() {

    var artistsRecyclerView: RecyclerView? = null
    val artists: MutableList<Artist> = ArrayList()
    val mainMenuAdapter: MainMenuAdapter = MainMenuAdapter(artists)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artists)
        setUpMainMenu()
    }

    fun setUpMainMenu() {
        artistsRecyclerView = findViewById(R.id.artistsRecyclerView) as RecyclerView
        val layoutManager = LinearLayoutManager(this)
        val spacesItemDecorator = SpacesItemDecoration(getResources().getInteger(R.integer.space_decorator))
        artistsRecyclerView?.addItemDecoration(spacesItemDecorator)
        artistsRecyclerView?.setLayoutManager(layoutManager)
        artistsRecyclerView?.setAdapter(mainMenuAdapter)
        val artistsObservable: Observable<List<Artist>> = EmbassatModel().getArtists()
        artistsObservable.subscribe{result -> onNewArtists(result)}
    }

    fun onNewArtists(newArtists: List<Artist>) {
        artists.clear()
        artists.addAll(newArtists)
        mainMenuAdapter.notifyDataSetChanged()
    }

    inner class MainMenuAdapter(items: List<Artist>) : RecyclerView.Adapter<MainMenuAdapter.MainMenuItemViewHolder>() {

        val items: List<Artist> = items

        override fun getItemCount(): Int {
            return items.size()
        }

        override fun onBindViewHolder(viewHolder: MainMenuItemViewHolder, position: Int) {
            val item = items[position]
            viewHolder.itemArtistTextView.setText(item.title)
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainMenuItemViewHolder? {
            val view = LayoutInflater.from(parent?.getContext()).inflate(R.layout.item_basic_text, parent, false)
            return MainMenuItemViewHolder(view);
        }

        inner class MainMenuItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            {
                view.setOnClickListener(OnMenuItemClickListener())
            }

            val itemArtistTextView = view.findViewById(R.id.itemBasicTextTextView) as TextView
        }

    }

    inner class SpacesItemDecoration(space: Int) : RecyclerView.ItemDecoration() {

        val space = space

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;

            if(parent.getChildAdapterPosition(view) == 0)
                outRect.top = space;
        }
    }

    inner class OnMenuItemClickListener : View.OnClickListener {

        override fun onClick(view: View) {
            val position = artistsRecyclerView?.getChildAdapterPosition(view)
            when (position) {
                //TODO navigate artist detail
            }
        }
    }

}