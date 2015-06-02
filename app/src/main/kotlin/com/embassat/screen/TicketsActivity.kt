package com.embassat.screen

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.widget.TextView
import com.embassat.R
import com.embassat.base.BaseActivity
import com.embassat.extension.openWeb

/**
 * Created by Quique on 16/5/15.
 */


public class TicketsActivity : BaseActivity() {

    val ticketeaUrl = "https://www.ticketea.com/entrades-embassat-2015/"

    override val layoutResource: Int = R.layout.activity_tickets

    override fun init() {
        setSupportActionBar(toolbar)
        getSupportActionBar().setDisplayShowTitleEnabled(false)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true)
        toolbarTitle.setText(R.string.title_activity_tickets)
        findViewById(R.id.compra_abonament_button).setOnClickListener{openWeb(ticketeaUrl)}
        findViewById(R.id.compra_entrada_dia_button).setOnClickListener{openWeb(ticketeaUrl)}
        findViewById(R.id.compra_entrada_petit_em_button).setOnClickListener{openWeb(ticketeaUrl)}
        (findViewById(R.id.activity_tickets_warning_text_view) as TextView).setText(Html.fromHtml("<font color=#f05158>*</font> <font color=#ffffff>Aforament limitat</font>"))
    }
}