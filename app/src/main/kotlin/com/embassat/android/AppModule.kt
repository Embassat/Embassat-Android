package com.embassat.android

import android.content.Context
import com.embassat.domain.interactor.base.Bus
import com.embassat.domain.interactor.base.InteractorExecutor
import com.path.android.jobqueue.JobManager
import java.util.Locale
import kotlin.properties.Delegates

/**
 * Created by Quique on 20/05/15.
 */
trait AppModule : AppContext, BusSingleton, InteractorExecutorSingleton, JobManagerSingleton, LanguageSingleton

class AppModuleImpl(context: Context): AppModule {
    override val appContext = context;
    override val bus by Delegates.lazy { BusImpl() }
    override val jobManager by Delegates.lazy { CustomJobManager(context) }
    override val interactorExecutor by Delegates.lazy { InteractorExecutorImpl(jobManager, bus) }
    override val language by Delegates.lazy { Locale.getDefault().getLanguage() }
}

trait AppContext {
    val appContext: Context
}

trait BusSingleton {
    val bus: Bus
}

trait JobManagerSingleton {
    val jobManager: JobManager
}

trait InteractorExecutorSingleton {
    val interactorExecutor: InteractorExecutor
}

trait LanguageSingleton {
    val language: String
}