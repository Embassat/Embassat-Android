package com.embassat.app.component

import com.embassat.app.module.AppModule
import com.embassat.app.module.CloudModule
import dagger.Component
import retrofit.RestAdapter
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, CloudModule::class))
interface CloudComponent {
    fun restAdapter(): RestAdapter
}