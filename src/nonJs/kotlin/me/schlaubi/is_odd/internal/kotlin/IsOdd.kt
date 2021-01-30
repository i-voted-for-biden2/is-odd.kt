package me.schlaubi.is_odd.internal.kotlin

class TypeError(message: String) : Throwable(message)

internal fun isOdd(input: Any?): Boolean {
    return when (input) {
        is Long -> (input and 1) == 1L
        is Int -> (input and 1) == 1
        !is Number -> throw TypeError("Expected an integer")
        else -> throw Error("Exceeds max integer")
    }
}
