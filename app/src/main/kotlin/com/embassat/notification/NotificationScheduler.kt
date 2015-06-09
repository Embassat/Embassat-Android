package com.embassat.notification

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.embassat.service.ScheduleService

/**
 * Created by Quique on 03/06/15.
 */
class NotificationScheduler {

    fun toggleNotification(context: Context, id: Int, time: Long, name: String?) {
        if (existsNotification(context, id))
            removeNotification(context, id)
        else
            addNotification(context, id, time, name)
    }

    fun addNotification(context: Context, id: Int, time: Long, name: String?) {
        val mgr = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, javaClass<ScheduleService>())
        intent.putExtra("name", name)
        intent.putExtra("id", id)
        val pendingIntent = PendingIntent?.getService(context, id, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        mgr.set(AlarmManager.RTC, time, pendingIntent)
    }

    fun removeNotification(context: Context, id: Int) {
        val mgr = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, javaClass<ScheduleService>())
        val pendingIntent = PendingIntent?.getService(context, id, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        pendingIntent.cancel()
        mgr.cancel(pendingIntent)
    }

    fun existsNotification(context: Context, id: Int): Boolean {
        val intent = Intent(context, javaClass<ScheduleService>())
        return PendingIntent.getService(context, id, intent, PendingIntent.FLAG_NO_CREATE) != null
    }
}