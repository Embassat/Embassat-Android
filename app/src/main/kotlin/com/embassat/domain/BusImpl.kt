package com.embassat.domain

import android.os.Handler
import android.os.Looper
import com.embassat.domain.interactor.base.Bus
import de.greenrobot.event.EventBus

/**
 * Created by Quique on 20/05/15.
 */

class BusImpl : EventBus(), Bus {

    val mainThread = Handler(Looper.getMainLooper())

    override fun post(event: Any) {
        mainThread.post({ super<EventBus>.post(event) })
    }
}