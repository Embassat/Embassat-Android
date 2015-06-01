package com.embassat.extension

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
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

inline public fun <reified T : Activity> Activity.navigate(id: Long) {
    val intent = Intent(this, javaClass<T>())
    intent.putExtra("ID", id)
    ActivityCompat.startActivity(this, intent, null)
}

public fun Activity.openWeb(url: String) {
    val intent = Intent(Intent.ACTION_VIEW)
    intent.setData(Uri.parse(url))
    ActivityCompat.startActivity(this, intent, null)
    startActivity(intent)
}