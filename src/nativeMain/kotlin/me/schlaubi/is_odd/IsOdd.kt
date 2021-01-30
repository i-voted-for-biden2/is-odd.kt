package me.schlaubi.is_odd

import me.schlaubi.is_odd.internal.kotlin.isOdd as kotlinIsOdd
import me.schlaubi.is_odd.internal.kotlin.TypeError

actual typealias TypeError = TypeError

actual fun isOdd(input: Any?): Boolean = kotlinIsOdd(input)
