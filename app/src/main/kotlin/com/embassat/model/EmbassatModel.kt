package com.embassat.model

import rx.Observable
import java.util.ArrayList

/**
 * Created by Quique on 17/5/15.
 */

private val artists : MutableList<Artist> = ArrayList()

public class EmbassatModel {

    public fun getArtists() : Observable<List<Artist>> {
        if (artists.size > 0) return Observable.just(artists)
        val artistsObservable = EmbassatAPI().getArtists()
        artistsObservable.subscribe{result -> updateArtists(result)}
        return artistsObservable
    }

    private fun updateArtists(newArtists: List<Artist>) {
        artists.clear()
        artists.addAll(newArtists)
    }
}