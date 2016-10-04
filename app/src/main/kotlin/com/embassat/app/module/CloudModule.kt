package com.embassat.app.module

import dagger.Module
import dagger.Provides
import retrofit.RestAdapter
import javax.inject.Singleton

@Module
class CloudModule {
    @Provides
    @Singleton
    fun providesRestAdapter(): RestAdapter {
        val HOST = "https://scorching-torch-2707.firebaseio.com"
        return RestAdapter.Builder().setEndpoint(HOST).build()
    }
}