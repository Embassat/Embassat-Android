package com.embassat.screen

import com.embassat.R
import com.embassat.base.BaseActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

/**
 * Created by Quique on 2/6/15.
 */

class MapActivity : BaseActivity() {

    override val layoutResource: Int = R.layout.activity_map

    override fun init() {

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbarTitle?.setText(R.string.title_activity_map)

        (supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment).getMapAsync() { map -> showAllMarkers(map) }
    }

    private fun showAllMarkers(googleMap: GoogleMap) {
        googleMap.addMarker(MarkerOptions().position(LatLng(41.5455645, 2.1046665)).title("Museu del Gas"))
        googleMap.addMarker(MarkerOptions().position(LatLng(41.5417171, 2.0969444)).title("Can Marcet"))
        googleMap.addMarker(MarkerOptions().position(LatLng(41.5464176, 2.1068468)).title("Pç del Dr Robert"))

        val center = CameraUpdateFactory.newLatLng(LatLng(41.546838, 2.106564))
        val zoom = CameraUpdateFactory.zoomTo(16f)

        googleMap.moveCamera(center)
        googleMap.animateCamera(zoom)
        googleMap.isMyLocationEnabled = true
    }
}