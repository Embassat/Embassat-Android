package com.embassat.domain

import com.embassat.domain.interactor.base.Bus
import com.embassat.domain.interactor.base.Interactor
import com.embassat.domain.interactor.base.InteractorPriority
import com.path.android.jobqueue.Job
import com.path.android.jobqueue.Params

/**
 * Created by Quique on 20/05/15.
 */
class InteractorWrapper(val interactor: Interactor, priority: InteractorPriority, val bus: Bus) : Job(Params(priority.value).requireNetwork()) {

    override fun onRun() {
        val event = interactor.invoke()
        bus.post(event)
    }

    override fun onAdded() = Unit
    override fun onCancel() = Unit
    override fun shouldReRunOnThrowable(throwable: Throwable?) = false
}