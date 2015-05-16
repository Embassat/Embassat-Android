package com.embassat.android

import android.content.Context
import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import com.embassat.R

public class MainActivity : AppCompatActivity() {

    var mainMenuRecyclerView : RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpMainMenu()
    }

    fun setUpMainMenu() {
        mainMenuRecyclerView = findViewById(R.id.mainMenuRecyclerView) as RecyclerView
        val layoutManager = LinearLayoutManager(this)
        val spacesItemDecorator = SpacesItemDecoration(getResources().getInteger(R.integer.space_decorator))
        mainMenuRecyclerView?.addItemDecoration(spacesItemDecorator)
        mainMenuRecyclerView?.setLayoutManager(layoutManager)
        mainMenuRecyclerView?.setAdapter(MainMenuAdapter(getResources().getStringArray(R.array.activity_main_options)))
    }

    inner class MainMenuAdapter(items: Array<String>) : RecyclerView.Adapter<MainMenuAdapter.MainMenuItemViewHolder>() {

        val items: Array<String> = items

        override fun getItemCount(): Int {
            return items.size()
        }

        override fun onBindViewHolder(viewHolder: MainMenuItemViewHolder, position: Int) {
            val item = items[position]
            viewHolder.itemMenuTextView.setText(item)
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainMenuItemViewHolder? {
            val view = LayoutInflater.from(parent?.getContext()).inflate(R.layout.item_basic_text, parent, false)
            return MainMenuItemViewHolder(view);
        }

        inner class MainMenuItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            {
                view.setOnClickListener(OnMenuItemClickListener())
            }

            val itemMenuTextView = view.findViewById(R.id.itemBasicTextTextView) as TextView
        }

    }

    inner class SpacesItemDecoration(space: Int) : RecyclerView.ItemDecoration() {

        val space = space

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;

            if(parent.getChildAdapterPosition(view) == 0)
                outRect.top = space*5;
        }
    }

    inner class OnMenuItemClickListener : View.OnClickListener {

        override fun onClick(view: View) {
            val position = mainMenuRecyclerView?.getChildAdapterPosition(view)
            when (position) {
                0 -> navigate<InfoActivity>()
                1 -> navigate<ArtistsActivity>()
                2 -> navigate<ScheduleActivity>()
                4 -> navigate<TicketsActivity>()
                5 -> navigate<ExtresActivity>()
            }
        }
    }
}