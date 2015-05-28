package com.embassat.module

import android.util.Log
import com.embassat.R
import com.embassat.module.AppContext
import com.embassat.module.AppModule
import com.embassat.model.EmbassatService
import retrofit.RestAdapter
import java.io.IOException

/**
 * Created by Quique on 20/05/15.
 */

public trait DataModule : EmbassatServiceSingleton

public trait EmbassatServiceSingleton {
    val embassatService: EmbassatService
}

class DataModuleImpl(appModule: AppModule) : DataModule, AppContext by appModule {

    override val embassatService: EmbassatService

    init {

        val HOST = "https://scorching-torch-2707.firebaseio.com"

        val restAdapter = RestAdapter.Builder()
                .setEndpoint(HOST)
                .build()

        embassatService = restAdapter.create(javaClass<EmbassatService>())
    }
}