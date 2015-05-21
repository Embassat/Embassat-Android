package com.embassat.domain

import com.embassat.domain.interactor.base.Bus
import com.embassat.domain.interactor.base.Interactor
import com.embassat.domain.interactor.base.InteractorExecutor
import com.embassat.domain.interactor.base.InteractorPriority
import com.path.android.jobqueue.JobManager

/**
 * Created by Quique on 20/05/15.
 */

class InteractorExecutorImpl(val jobManager: JobManager, val bus: Bus) : InteractorExecutor {

    override fun execute(interactor: Interactor, priority: InteractorPriority) {
        jobManager.addJob(InteractorWrapper(interactor, priority,  bus))
    }
}