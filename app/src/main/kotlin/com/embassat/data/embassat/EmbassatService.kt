package com.embassat.data.embassat

import com.embassat.data.embassat.model.EmbassatArtist
import retrofit.Callback
import retrofit.RestAdapter
import retrofit.http.GET
import retrofit.http.Path

/**
 * Created by Quique on 14/04/15.
 */
interface EmbassatService {
    @GET("/artists.json")
    fun getArtists(): List<EmbassatArtist>

    @GET("posts/{id}")
    fun getArtist(@Path("id") id: Long): EmbassatArtist
}