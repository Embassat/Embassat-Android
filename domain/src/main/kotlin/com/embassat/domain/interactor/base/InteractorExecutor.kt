package com.embassat.domain.interactor.base

/**
 * Created by Quique on 20/05/15.
 */

trait InteractorExecutor {
    fun execute(interactor: Interactor, priority: InteractorPriority = InteractorPriority.LOW)
}