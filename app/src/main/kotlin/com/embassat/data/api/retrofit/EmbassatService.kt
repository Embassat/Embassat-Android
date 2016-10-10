package com.embassat.data.api.retrofit

import com.embassat.data.api.model.ArtistApi
import retrofit.Callback
import retrofit.http.GET
import retrofit.http.Path

interface EmbassatService {
    @GET("/artists.json")
    fun getArtists(): List<ArtistApi>

    @GET("/artists.json")
    fun getArtists(callback: Callback<List<ArtistApi>>)

    @GET("posts/{id}")
    fun getArtist(@Path("id") id: Long): ArtistApi
}