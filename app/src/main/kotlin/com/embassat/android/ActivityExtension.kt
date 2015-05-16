package com.embassat.android

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.ActionBarActivity
import com.embassat.R

/**
 * Created by Quique on 16/5/15.
 */

inline public fun <reified T : Activity> Activity.navigate() {
    val intent = Intent(this, javaClass<T>())
    ActivityCompat.startActivity(this, intent, null)
}