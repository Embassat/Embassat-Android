package com.embassat.presentation.presenter

import com.embassat.domain.interactor.base.Bus

/**
 * Created by Quique on 20/05/15.
 */
trait Presenter<T> {

    val view: T
    val bus: Bus

    fun onResume(){
        bus.register(this)
    }

    fun onPause(){
        bus.unregister(this)
    }
}