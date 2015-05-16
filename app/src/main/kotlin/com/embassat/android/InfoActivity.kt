package com.embassat.android

import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.embassat.R

/**
 * Created by Quique on 16/5/15.
 */

public class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val embassatImageView = findViewById(R.id.embassat_image) as ImageView
        val escenariImageView = findViewById(R.id.principal_image) as ImageView
        val amfiteatreImageView = findViewById(R.id.amfiteatre_image) as ImageView
        val miradorImageView = findViewById(R.id.mirador_image) as ImageView

        Glide.with(this).load(R.drawable.embassat).into(embassatImageView)
        Glide.with(this).load(R.drawable.principal).into(escenariImageView)
        Glide.with(this).load(R.drawable.amfiteatre).into(amfiteatreImageView)
        Glide.with(this).load(R.drawable.mirador).into(miradorImageView)
    }

}