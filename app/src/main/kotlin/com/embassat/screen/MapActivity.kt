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
        googleMap.addMarker(MarkerOptions().position(LatLng(41.553602, 2.099773)).title("Escenari Principal"))
        googleMap.addMarker(MarkerOptions().position(LatLng(41.554052, 2.099800)).title("Yeearphone"))
        googleMap.addMarker(MarkerOptions().position(LatLng(41.545738, 2.106824)).title("Mirador Museu del Gas"))

        googleMap.addMarker(MarkerOptions().position(LatLng(41.5493037, 2.1083694)).title("Balboa").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        googleMap.addMarker(MarkerOptions().position(LatLng(41.5460348, 2.1132087)).title("Kräsna").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))

        val center = CameraUpdateFactory.newLatLng(LatLng(41.546838, 2.106564))
        val zoom = CameraUpdateFactory.zoomTo(16f)

        googleMap.moveCamera(center)
        googleMap.animateCamera(zoom)
        googleMap.isMyLocationEnabled = true
    }
}