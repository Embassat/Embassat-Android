package com.embassat.app.module

import com.embassat.domain.repository.ArtistRepository
import com.embassat.domain.repository.ArtistRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun providesArtistRepository(artistRepositoryImpl: ArtistRepositoryImpl): ArtistRepository {
        return artistRepositoryImpl
    }
}