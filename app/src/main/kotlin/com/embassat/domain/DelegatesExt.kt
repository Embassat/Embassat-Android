package com.embassat.domain

import kotlin.properties.ReadOnlyProperty

/**
 * Created by Quique on 20/05/15.
 */

object DelegatesExt {
    fun provider<T>(initializer: () -> T): ReadOnlyProperty<Any?, T> = Provider(initializer)
}

private class Provider<T>(private val initializer: () -> T) : ReadOnlyProperty<Any?, T> {
    override fun get(thisRef: Any?, desc: PropertyMetadata): T {
        return initializer()
    }
}