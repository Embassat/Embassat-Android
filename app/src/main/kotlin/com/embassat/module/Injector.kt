package com.embassat.module

import com.embassat.module.AppModule
import com.embassat.module.DataModule
import com.embassat.module.DomainModule
import com.embassat.module.RepositoryModule
import kotlin.properties.Delegates

/**
 * Created by Quique on 20/05/15.
 */

interface  Injector : AppModule, DomainModule, RepositoryModule, DataModule

class InjectorImpl(
        appModule: AppModule,
        domainModule: DomainModule,
        repositoryModule: RepositoryModule,
        dataModule: DataModule) : Injector,
        AppModule by appModule,
        DomainModule by domainModule,
        RepositoryModule by repositoryModule,
        DataModule by dataModule

object Inject {
    var instance: Injector by Delegates.notNull()
}