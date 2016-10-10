package com.embassat.app.module

import com.embassat.data.api.model.ArtistApiMapper
import com.embassat.data.api.model.ArtistApiMapperImpl
import com.embassat.data.model.ArtistDataMapper
import com.embassat.data.model.ArtistDataMapperImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MapperModule {
    @Provides
    @Singleton
    fun provideArtistApiMapper(artistApiMapperImpl: ArtistApiMapperImpl): ArtistApiMapper {
        return artistApiMapperImpl
    }

    @Provides
    @Singleton
    fun provideArtistDataMapper(artistDataMapperImpl: ArtistDataMapperImpl): ArtistDataMapper {
        return artistDataMapperImpl
    }
}