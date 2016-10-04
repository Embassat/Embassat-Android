package com.embassat

import android.app.Application
import com.embassat.module.*

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