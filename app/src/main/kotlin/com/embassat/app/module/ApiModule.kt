package com.embassat.app.module

import com.embassat.data.api.EmbassatApi
import com.embassat.data.api.retrofit.RetrofitEmbassatApi
import dagger.Module
import dagger.Provides
import retrofit.RestAdapter
import javax.inject.Singleton

@Module
class ApiModule {
    @Provides
    @Singleton
    fun providesRestAdapter(): RestAdapter {
        val HOST = "https://scorching-torch-2707.firebaseio.com"
        return RestAdapter.Builder().setEndpoint(HOST).build()
    }

    @Provides
    @Singleton
    fun providesEmbassatApi(restAdapter: RestAdapter): EmbassatApi {
        return restAdapter.create(RetrofitEmbassatApi::class.java)
    }
}