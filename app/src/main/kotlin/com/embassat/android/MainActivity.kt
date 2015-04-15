package com.embassat.android

import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.embassat.R
import com.embassat.logic.EmbassatAPI
import com.embassat.model.Artist
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.lang.kotlin.onError
import rx.lang.kotlin.subscriber
import rx.schedulers.Schedulers

public class MainActivity : ActionBarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val obs = EmbassatAPI().getArtists()
        obs.subscribe {
                    result ->
                    for(i in 0..result.size()-1){
                        Log.d("EMBASSAT", result.get(i).ID.toString())
                        Log.d("EMBASSAT", result.get(i).title)
                        Log.d("EMBASSAT", result.get(i).featured_image.guid)

                    }
                    showImage(result.get(0).featured_image.guid)
                }
    }

    fun showImage(image: String) {
        val imageView = findViewById(R.id.artist_photo) as ImageView
        Glide.with(this).load(image).into(imageView)
    }
}