package com.embassat.app.module

import com.embassat.data.datasource.ArtistDataSource
import com.embassat.data.datasource.cloud.CloudArtistDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {
    @Provides
    @Singleton
    fun providesArtistDataSource(cloudArtistDataSource: CloudArtistDataSource): ArtistDataSource {
        return cloudArtistDataSource
    }
}