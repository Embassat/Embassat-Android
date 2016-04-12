package com.embassat.domain

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Created by Quique on 20/05/15.
 */

object DelegatesExt {
    fun <T>provider(initializer: () -> T): ReadOnlyProperty<Any?, T> = Provider(initializer)
}

private class Provider<T>(private val initializer: () -> T) : ReadOnlyProperty<Any?, T> {

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return initializer()
    }
}