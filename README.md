# is-odd.kt
Kotlin port of very popular JavaScript library [is-odd](https://www.npmjs.com/package/is-odd)

Kotlin/JS introduced a cool thing to Kotlin which we were all missing before. The `dynamic` type. But there is only one problem with that. You can no longer figure out whether something is even or odd. So this library introduces a very helpful helper function called isOdd

# How this works
- On Kotlin/JS this uses the very popular library [is-odd](https://www.npmjs.com/package/is-odd)
- On all Kotlin/JVM and Kotlin/Native this uses its own implementation: [IsOdd.kt](https://github.com/DRSchlaubi/is-odd.kt/blob/main/src/nonJs/kotlin/me/schlaubi/is_odd/internal/kotlin/IsOdd.kt)

# Usage
The library is hosted on JCenter (if I will ever get to publish this)