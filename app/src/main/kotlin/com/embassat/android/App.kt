package com.embassat.android

import android.app.Application

/**
 * Created by Quique on 20/05/15.
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instantiateInjector()
    }

    fun instantiateInjector() {
        val appModule = AppModuleImpl(this)
        val dataModule = DataModuleImpl(appModule)
        val repositoryModule = RepositoryModuleImpl(appModule, dataModule)
        val domainModule = DomainModuleImpl(repositoryModule)
        Inject.instance = InjectorImpl(appModule, domainModule, repositoryModule, dataModule)
    }
}