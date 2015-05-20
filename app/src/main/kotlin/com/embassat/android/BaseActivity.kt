package com.embassat.android

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.embassat.R

/**
 * Created by Quique on 20/05/15.
 */

abstract class BaseActivity : AppCompatActivity() {

    protected abstract val layoutResource : Int
    protected val toolbar : Toolbar by bindView(R.id.toolbar)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResource)
        setSupportActionBar(toolbar)
    }
}