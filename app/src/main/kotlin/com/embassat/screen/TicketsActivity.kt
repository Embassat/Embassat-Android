package com.embassat.screen

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.embassat.R
import com.embassat.extension.openWeb

/**
 * Created by Quique on 16/5/15.
 */


public class TicketsActivity : AppCompatActivity() {

    val ticketeaUrl = "https://www.ticketea.com/embassat-2014-festival-independent-del-valles/"
    val descompteUrl = "http://www.tresc.cat/fitxa/concerts/43054/Embassat-2014"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tickets)

        findViewById(R.id.compra_abonament_button).setOnClickListener{openWeb(ticketeaUrl)}
        findViewById(R.id.compra_entrada_dia_button).setOnClickListener{openWeb(ticketeaUrl)}
        findViewById(R.id.compra_hotel_button).setOnClickListener{openWeb(ticketeaUrl)}
        findViewById(R.id.compra_descompte_button).setOnClickListener{openWeb(descompteUrl)}
    }
}