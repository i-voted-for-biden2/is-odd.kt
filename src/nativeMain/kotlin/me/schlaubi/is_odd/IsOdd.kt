package me.schlaubi.is_odd

import me.schlaubi.is_odd.internal.kotlin.isOdd as kotlinIsOdd

actual fun isOdd(input: Any?): Boolean = kotlinIsOdd(input)
