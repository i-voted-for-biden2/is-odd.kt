package me.schlaubi.is_odd

import me.schlaubi.is_odd.internal.js.TypeError
import me.schlaubi.is_odd.internal.js.Error as JsError
import kotlin.Error as KotlinError
import me.schlaubi.is_odd.internal.js.isOdd as jsIsOdd

actual typealias TypeError = TypeError

actual fun isOdd(input: Any?): Boolean {
    try {
        return jsIsOdd(input)
    } catch (e: Throwable) {
        if (e !is TypeError) {
            if (e is JsError) {
                throw KotlinError(e.message)
            }
        }
        throw e
    }
}
