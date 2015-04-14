package com.embassat.logic

import com.embassat.model.Artist
import retrofit.http.GET
import rx.Observable

/**
 * Created by Quique on 14/04/15.
 */
trait ArtistsApi {
    GET("/posts?type=portfolio")
    fun getArtists(): Observable<List<Artist>>
}