package me.schlaubi.is_odd

/**
 * Error indicating that another type was expected.
 */
expect class TypeError : Throwable

/**
 * Checks whether [input] is an odd number
 *
 * @throws TypeError if [input] is not an [Int] or a [Long]
 * @throws Error if [input] exceeds [Long.MAX_VALUE]
 *
 * @return whether [input] is an odd-number or not
 */
expect fun isOdd(input: Any?): Boolean
