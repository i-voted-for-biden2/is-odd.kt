package me.schlaubi.is_odd

import me.schlaubi.is_odd.internal.js.isOdd as jsIsOdd

actual fun isOdd(input: Any?): Boolean = runCatching { jsIsOdd(input) }.getOrElse { false }
