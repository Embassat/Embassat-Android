package com.embassat.module

import android.content.Context
import com.embassat.domain.BusImpl
import com.embassat.domain.CustomJobManager
import com.embassat.domain.InteractorExecutorImpl
import com.embassat.domain.interactor.base.Bus
import com.embassat.domain.interactor.base.InteractorExecutor
import com.path.android.jobqueue.JobManager
import java.util.Locale
import kotlin.properties.Delegates

/**
 * Created by Quique on 20/05/15.
 */
interface  AppModule : AppContext, BusSingleton, InteractorExecutorSingleton, JobManagerSingleton, LanguageSingleton

class AppModuleImpl(context: Context): AppModule {
    override val appContext = context;
    override val bus = BusImpl()
    override val jobManager = CustomJobManager(context)
    override val interactorExecutor = InteractorExecutorImpl(jobManager, bus)
    override val language = Locale.getDefault().getLanguage()
}

interface AppContext {
    val appContext: Context
}

interface BusSingleton {
    val bus: Bus
}

interface JobManagerSingleton {
    val jobManager: JobManager
}

interface InteractorExecutorSingleton {
    val interactorExecutor: InteractorExecutor
}

interface LanguageSingleton {
    val language: String
}