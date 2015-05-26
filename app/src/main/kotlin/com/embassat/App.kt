package com.embassat

import android.app.Application
import com.embassat.domain.*
import com.embassat.module.*
import com.firebase.client.Firebase

/**
 * Created by Quique on 20/05/15.
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Firebase.setAndroidContext(this)
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