package me.schlaubi.is_odd.internal.kotlin

import kotlin.math.ceil

class TypeError(message: String) : Throwable(message)

internal const val MAX_SAFE_INTEGER = 9007199254740991L
internal const val MIN_SAFE_INTEGER = -9007199254740991L

internal fun isOdd(input: Any?): Boolean {
    val parsedInput = if(input is CharSequence) {
        input.toString().toDoubleOrNull() ?: input
    } else {
        input
    }

    return when (parsedInput) {
        !is Number -> throw TypeError("expected a number")
        else -> {
            val double = parsedInput.toDouble()
            if (ceil(double) != double) throw Error("expected an integer")

            val longValue = parsedInput.toLong()
            if (longValue !in -9007199254740991L..9007199254740991L) {
                throw Error("value exceeds maximum safe integer")
            }

            (parsedInput.toLong() % 2) == 1L
        }
    }
}
