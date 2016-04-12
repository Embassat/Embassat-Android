package com.embassat.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.TextView
import com.embassat.R

/**
 * Created by Quique on 20/05/15.
 */

abstract class BaseActivity : AppCompatActivity() {

    protected abstract val layoutResource : Int
    protected val toolbar = findViewById(R.id.toolbar) as Toolbar
    protected val toolbarTitle = findViewById(R.id.toolbar_title) as TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResource)
        init()
    }

    abstract fun init()
}