package com.embassat.adapter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.embassat.presentation.entity.ArtistDetail
import com.embassat.presentation.entity.ArtistName
import com.embassat.screen.ArtistDetailFragment
import com.embassat.screen.ScheduleListFragment

/**
 * Created by Quique on 25/5/15.
 */

class ArtistsPagerFragmentAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    var items: List<ArtistDetail>? = null
        set(value) {
            $items = value
            notifyDataSetChanged()
        }

    override fun getCount() = items?.size() ?: 0

    override fun getItem(position: Int): Fragment {
        val fragment = ArtistDetailFragment()

        val args = Bundle()
        args.putSerializable("artist", items?.get(position))
        fragment.setArguments(args)

        return fragment
    }

    fun getItemPositionById(id: Long) : Int {
        for (i in items!!.indices) {
            if (items!!.get(i).id == id) return i
        }
        return -1
    }
}