package me.schlaubi.is_odd.internal.kotlin

import kotlin.math.ceil

class TypeError(message: String) : Throwable(message)

internal fun isOdd(input: Any?): Boolean = when (input) {
    !is Number -> throw TypeError("expected a number")
    else -> {
        val double = input.toDouble()
        if (ceil(double) != double) throw Error("expected an integer")

        val longValue = input.toLong()
        if (longValue !in -9007199254740991L..9007199254740991L) {
            throw Error("value exceeds maximum safe integer")
        }

        (input.toLong() % 2) == 1L
    }
}
