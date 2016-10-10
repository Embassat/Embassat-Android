package com.embassat.app.component

import com.embassat.app.module.ApiModule
import com.embassat.data.api.EmbassatApi
import dagger.Component
import retrofit.RestAdapter
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApiModule::class))
interface ApiComponent {
    fun restAdapter(): RestAdapter
    fun embassatApi(): EmbassatApi
}