package com.embassat.screen

import android.text.Html
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.embassat.R
import com.embassat.base.BaseActivity
import com.embassat.extension.openWeb

/**
 * Created by Quique on 16/5/15.
 */


public class TicketsActivity : BaseActivity() {

    val ticketeaUrl = "http://entradium.com/sites/MjQ0Mg=="

    override val layoutResource: Int = R.layout.activity_tickets

    override fun init() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbarTitle?.setText(R.string.title_activity_tickets)
        findViewById(R.id.compra_abonament_button).setOnClickListener{openWeb(ticketeaUrl)}
        findViewById(R.id.compra_entrada_dia_button).setOnClickListener{openWeb(ticketeaUrl)}
        findViewById(R.id.compra_entrada_petit_em_button).setOnClickListener{openWeb(ticketeaUrl)}

        val embassatImageView = findViewById(R.id.embassat_image) as ImageView
        Glide.with(this).load(R.drawable.groc).into(embassatImageView)
    }
}