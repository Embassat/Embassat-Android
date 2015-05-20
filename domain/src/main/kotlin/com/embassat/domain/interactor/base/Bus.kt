package com.embassat.domain.interactor.base

/**
 * Created by Quique on 20/05/15.
 */

trait Bus {
    fun post(event: Any): Unit
    fun register(observer: Any): Unit
    fun unregister(observer: Any): Unit
}