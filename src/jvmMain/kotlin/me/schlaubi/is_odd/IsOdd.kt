package me.schlaubi.is_odd

import me.schlaubi.is_odd.internal.kotlin.isOdd as kotlinIsOdd
import me.schlaubi.is_odd.internal.kotlin.TypeError

actual val Long.Companion.MAX_SAFE_INTEGER: Long
    get() = me.schlaubi.is_odd.internal.kotlin.MAX_SAFE_INTEGER
actual val Long.Companion.MIN_SAFE_INTEGER: Long
    get() = me.schlaubi.is_odd.internal.kotlin.MIN_SAFE_INTEGER

actual typealias TypeError = TypeError

actual fun isOdd(input: Any?): Boolean = kotlinIsOdd(input)
