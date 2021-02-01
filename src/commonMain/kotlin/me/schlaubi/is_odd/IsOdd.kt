@file:JvmName("IsOddInterface")

package me.schlaubi.is_odd

import kotlin.jvm.JvmName

/**
 * The MAX_SAFE_INTEGER constant represents the [maximum safe integer in JavaScript](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Number/MAX_SAFE_INTEGER) (2^53 - 1).
 */
expect val Long.Companion.MAX_SAFE_INTEGER: Long

/**
 * The MIN_SAFE_INTEGER constant represents the [minimum safe integer in JavaScript](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Number/min_SAFE_INTEGER) (2^53 - 1).
 */
expect val Long.Companion.MIN_SAFE_INTEGER: Long

/**
 * Error indicating that another type was expected.
 */
expect class TypeError : Throwable

/**
 * Checks whether [input] is an odd number
 *
 * @throws TypeError if [input] is not an [Int] or a [Long]
 * @throws Error if [input] exceeds [MAX_SAFE_INTEGER] or [MIN_SAFE_INTEGER] or is not an Integer
 *
 * @return whether [input] is an odd-number or not
 */
expect fun isOdd(input: Any?): Boolean
