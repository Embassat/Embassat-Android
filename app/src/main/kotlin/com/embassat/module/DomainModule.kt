package com.embassat.module

import com.embassat.module.ArtistRepositorySingleton
import com.embassat.domain.DelegatesExt
import com.embassat.module.RepositoryModule
import com.embassat.domain.interactor.GetArtistInteractor
import com.embassat.domain.interactor.GetArtistsInteractor

/**
 * Created by Quique on 20/05/15.
 */

public trait DomainModule : GetArtistsInteractorProvider

public trait GetArtistsInteractorProvider {
    val artistsInteractorProvider: GetArtistsInteractor
    val artistInteractorProvider: GetArtistInteractor
}

class DomainModuleImpl(repositoryModule: RepositoryModule) : DomainModule,
        ArtistRepositorySingleton by repositoryModule {

    override val artistsInteractorProvider by DelegatesExt.provider {
        GetArtistsInteractor(artistRepository)
    }

    override val artistInteractorProvider by DelegatesExt.provider {
        GetArtistInteractor(artistRepository)
    }
}