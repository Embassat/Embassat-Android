package com.embassat.domain.interactor.base

/**
 * Created by Quique on 20/05/15.
 */

interface Interactor {

    fun invoke(): Event
}