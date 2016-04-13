package com.embassat.screen

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.embassat.R
import com.embassat.base.BaseActivity

/**
 * Created by Quique on 16/5/15.
 */

public class ExtraActivity : BaseActivity() {

    override val layoutResource: Int = R.layout.activity_extres

    override fun init() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbarTitle?.setText(R.string.title_activity_extres)
    }
}