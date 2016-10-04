package com.embassat.app.component

import com.embassat.app.annotation.PerView
import com.embassat.screen.ArtistsActivity
import dagger.Component

@PerView
@Component(dependencies = arrayOf(CloudComponent::class))
interface ArtistsViewComponent {
    fun inject(artistsActivity: ArtistsActivity)
}