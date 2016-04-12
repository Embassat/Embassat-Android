package com.embassat.model

import android.util.Log
import retrofit.RestAdapter
import retrofit.http.GET
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Quique on 14/04/15.
 */

class EmbassatAPI {

    val HOST = "http://www.embassat.com/wp-json"

    fun getArtistsService() : ArtistsApi {
        return RestAdapter.Builder()
                .setEndpoint(HOST)
                .build()
                .create(ArtistsApi::class.java)
    }

    public fun getArtists() : Observable<List<Artist>> {
        return getArtistsService()
                .getArtists()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    interface ArtistsApi {
        @GET("/posts?type=portfolio")
        fun getArtists(): Observable<List<Artist>>
    }
}