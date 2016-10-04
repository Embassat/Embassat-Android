package com.embassat.module

import com.embassat.data.CloudArtistDataSource
import com.embassat.domain.repository.ArtistRepository
import com.embassat.repository.ArtistRepositoryImp

/**
 * Created by Quique on 20/05/15.
 */

public interface  RepositoryModule : ArtistRepositorySingleton

public interface  ArtistRepositorySingleton {
    val artistRepository: ArtistRepository
}

class RepositoryModuleImpl(appModule: AppModule, dataModule: DataModule) :
        RepositoryModule,
        LanguageSingleton by appModule, EmbassatServiceSingleton by dataModule {

    override val artistRepository = ArtistRepositoryImp(listOf(CloudArtistDataSource(language, embassatService)))
}