package com.embassat.module

import com.embassat.data.api.EmbassatService
import retrofit.RestAdapter

/**
 * Created by Quique on 20/05/15.
 */

public interface  DataModule : EmbassatServiceSingleton

public interface  EmbassatServiceSingleton {
    val embassatService: EmbassatService
}

class DataModuleImpl(appModule: AppModule) : DataModule, AppContext by appModule {

    override val embassatService: EmbassatService

    init {

        val HOST = "https://scorching-torch-2707.firebaseio.com"

        val restAdapter = RestAdapter.Builder()
                .setEndpoint(HOST)
                .build()

        embassatService = restAdapter.create(EmbassatService::class.java)
    }
}