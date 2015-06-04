package com.embassat.service

import android.app.IntentService
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v4.app.NotificationCompat
import android.support.v4.app.TaskStackBuilder
import android.util.Log
import com.embassat.R
import com.embassat.screen.MainActivity
import com.embassat.screen.ScheduleActivity

/**
 * Created by Quique on 04/06/15.
 */
class ScheduleService() : IntentService("") {

    override fun onHandleIntent(p0: Intent?) {
        val intent = Intent(this, javaClass<ScheduleActivity>())
        val pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        // build notification
        // the addAction re-use the same intent to keep the example short
        val n  = NotificationCompat.Builder(this)
                .setContentTitle("New mail from " + "test@gmail.com")
                .setContentText("Subject")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pIntent)
                .setAutoCancel(true)
                .build()

        val  notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager;

        notificationManager.notify(0, n);
    }

}