package com.embassat.data.api.retrofit

import com.embassat.data.api.EmbassatApi
import com.embassat.data.api.model.ArtistApi
import javax.inject.Inject

class RetrofitEmbassatApi @Inject constructor(val embassatService: EmbassatService) : EmbassatApi {
    override fun getArtists(): List<ArtistApi> {
        return embassatService.getArtists()
    }
}