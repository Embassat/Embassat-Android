package com.embassat.module

import android.util.Log
import com.embassat.R
import com.embassat.module.AppContext
import com.embassat.module.AppModule
import com.embassat.model.EmbassatService
import com.firebase.client.Firebase
import retrofit.RestAdapter
import java.io.IOException

/**
 * Created by Quique on 20/05/15.
 */

public trait DataModule : EmbassatServiceSingleton

public trait EmbassatServiceSingleton {
    val embassatService: EmbassatService
    val firebaseReference : Firebase
}

class DataModuleImpl(appModule: AppModule) : DataModule, AppContext by appModule {

    override val firebaseReference: Firebase
    override val embassatService: EmbassatService

    init {

        val HOST = "http://www.embassat.com/wp-json"

        val restAdapter = RestAdapter.Builder()
                .setEndpoint(HOST)
                .build()

        embassatService = restAdapter.create(javaClass<EmbassatService>()) ;
        firebaseReference = Firebase("https://scorching-torch-2707.firebaseio.com/")
    }
}