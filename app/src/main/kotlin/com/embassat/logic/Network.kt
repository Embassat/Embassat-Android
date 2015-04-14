package com.embassat.logic

import retrofit.RestAdapter

/**
 * Created by Quique on 14/04/15.
 */

public class Network {

    val HOST = "http://www.embassat.com/wp-json"
    init {
        var restAdapter = RestAdapter.Builder()
                .setEndpoint(HOST)
                .build()
    }
}
