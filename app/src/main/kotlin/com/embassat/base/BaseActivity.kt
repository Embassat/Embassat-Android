package com.embassat.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.TextView
import com.embassat.R

/**
 * Created by Quique on 20/05/15.
 */

abstract class BaseActivity : AppCompatActivity() {

    protected abstract val layoutResource : Int
    protected var toolbar : Toolbar? = null
    protected var toolbarTitle : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResource)
        toolbar = initToolbar()
        toolbarTitle = initToolbarTextView()
        init()
    }

    private fun initToolbar() : Toolbar? {
        val view : View? = findViewById(R.id.toolbar)
        if (view == null) {
            return view
        }
        return view as Toolbar
    }

    private fun initToolbarTextView() : TextView? {
        val view : View? = findViewById(R.id.toolbar_title)
        if (view == null) {
            return view
        }
        return view as TextView
    }

    abstract fun init()
}