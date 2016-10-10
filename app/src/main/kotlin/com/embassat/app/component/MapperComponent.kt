package com.embassat.app.component

import com.embassat.app.module.MapperModule
import com.embassat.data.api.model.ArtistApiMapper
import com.embassat.data.model.ArtistDataMapper
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(MapperModule::class))
interface MapperComponent {
    fun artistApiMapper(): ArtistApiMapper
    fun artistDataMapper(): ArtistDataMapper
}