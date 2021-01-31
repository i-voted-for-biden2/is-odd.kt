# is-odd.kt
Kotlin port of very popular JavaScript library [is-odd](https://www.npmjs.com/package/is-odd)

Kotlin/JS introduced a cool thing to Kotlin which we were all missing before. The `dynamic` type. But there is only one problem with that. You can no longer figure out whether something is even or odd. So this library introduces a very helpful helper function called isOdd

# How this works
- On Kotlin/JS this uses the very popular library [is-odd](https://www.npmjs.com/package/is-odd)
- On all Kotlin/JVM and Kotlin/Native this uses its own implementation: [IsOdd.kt](https://github.com/DRSchlaubi/is-odd.kt/blob/main/src/nonJs/kotlin/me/schlaubi/is_odd/internal/kotlin/IsOdd.kt)

# Usage
The library is hosted on [Bintray](https://bintray.com/beta/#/drschlaubi/maven/is-odd.kt?tab=overview)

Gradle:
```kotlin
    kotlin {
        sourceSets {
            commonMain {
                repositories {
                    maven("https://dl.bintray.com/drschlaubi/maven")
                }
                
                dependencies {
                    implementation("me.schlaubi", "is-odd", "1.1")
                }
            }
        }    
    }
```

# Documentation
Docs can be found here: https://isodd.schlau.bi/is-odd
