package com.embassat.app.component

import com.embassat.app.module.RepositoryModule
import com.embassat.domain.repository.ArtistRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(RepositoryModule::class))
interface RepositoryComponent {
    fun artistRepository(): ArtistRepository
}