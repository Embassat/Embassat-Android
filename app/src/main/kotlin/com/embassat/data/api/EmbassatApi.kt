package com.embassat.data.api

import com.embassat.data.api.model.ArtistApi

interface EmbassatApi {
    fun getArtists(): List<ArtistApi>
}