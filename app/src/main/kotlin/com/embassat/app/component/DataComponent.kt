package com.embassat.app.component

import com.embassat.data.datasource.ArtistDataSource
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(DataComponent::class))
interface DataComponent {
    fun artistDataSource(): ArtistDataSource
}