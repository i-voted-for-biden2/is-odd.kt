package me.schlaubi.is_odd.internal.js

internal external class Error : Throwable {
    override val message: String
}

external class TypeError : Throwable {
    override val message: String
}
