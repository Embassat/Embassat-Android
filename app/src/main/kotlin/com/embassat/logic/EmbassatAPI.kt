package com.embassat.logic

import android.util.Log
import com.embassat.model.Artist
import retrofit.RestAdapter
import retrofit.http.GET
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.lang.kotlin.onError
import rx.schedulers.Schedulers

/**
 * Created by Quique on 14/04/15.
 */

public class EmbassatAPI {

    val TAG = "Embassat2015 Network"

    val HOST = "http://www.embassat.com/wp-json"
    init {
        var api = RestAdapter.Builder()
                .setEndpoint(HOST)
                .build()
                .create(javaClass<ArtistsApi>())
        var obs = api.getArtists()
        obs.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .onError { e -> Log.d(TAG, e.getMessage()) }
            .subscribe { result ->
                for(i in 0..result.size()-1){
                    Log.d(TAG, result.get(i).title)
                }
            }

    }

    trait ArtistsApi {
        GET("/posts?type=portfolio")
        fun getArtists(): Observable<List<Artist>>
    }
}
