package com.embassat.domain.interactor.base

/**
 * Created by Quique on 20/05/15.
 */

trait Interactor {

    fun invoke(): Event
}