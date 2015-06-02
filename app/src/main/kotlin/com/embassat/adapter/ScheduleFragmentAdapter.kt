package com.embassat.adapter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.embassat.presentation.entity.ArtistSchedule
import com.embassat.screen.ScheduleListFragment
import java.util.ArrayList

/**
 * Created by Quique on 25/5/15.
 */

class ScheduleFragmentAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        val fragment = ScheduleListFragment()

        val args = Bundle()
        args.putInt("extra_position", position)
        fragment.setArguments(args)

        return fragment
    }
}