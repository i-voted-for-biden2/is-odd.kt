package me.schlaubi.is_odd.internal.kotlin

internal fun isOdd(input: Any?): Boolean {
    return when (input) {
        is Long -> (input and 1) == 1L
        is Int -> (input and 1) == 1
        else -> false
    }
}
