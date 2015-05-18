package com.embassat.model

import android.util.Log
import retrofit.RestAdapter
import retrofit.http.GET
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.lang.kotlin.onError
import rx.schedulers.Schedulers

/**
 * Created by Quique on 14/04/15.
 */

private class EmbassatAPI {

    val HOST = "http://www.embassat.com/wp-json"

    fun getArtistsService() : ArtistsApi {
        return RestAdapter.Builder()
                .setEndpoint(HOST)
                .build()
                .create(javaClass<ArtistsApi>())
    }

    public fun getArtists() : Observable<List<Artist>> {
        return getArtistsService()
                .getArtists()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .onError { e -> Log.d("EMBASSAT", e.getMessage()) }
    }

    trait ArtistsApi {
        GET("/posts?type=portfolio")
        fun getArtists(): Observable<List<Artist>>
    }
}