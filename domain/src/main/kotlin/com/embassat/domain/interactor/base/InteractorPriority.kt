package com.embassat.domain.interactor.base

/**
 * Created by Quique on 20/05/15.
 */

enum class InteractorPriority(val value: Int) {
    LOW : InteractorPriority(0)
    MID : InteractorPriority(500)
    HIGH : InteractorPriority(1000)
}