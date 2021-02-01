import me.schlaubi.is_odd.TypeError
import me.schlaubi.is_odd.isOdd
import kotlin.test.*

class IsOddTest {

    @Test
    fun oddNumber() {
        assertTrue(isOdd(1), "1 is an odd number")
        assertTrue(isOdd(Int.MAX_VALUE), "Int max is an odd number")
    }

    @Test
    fun evenNumber() {
        assertFalse(isOdd(2), "2 is even number")
        assertFalse(isOdd(Int.MIN_VALUE), "Int min is an even number")
    }

    @Suppress("LocalVariableName")
    @Test
    fun exceeds() {
        val MAX_SAFE_INTEGER = 9007199254740991L
        val MIN_SAFE_INTEGER = -9007199254740991L
        assertFailsWith<Error> { isOdd(MAX_SAFE_INTEGER + 1) }
        assertFailsWith<Error> { isOdd(MIN_SAFE_INTEGER - 1) }
    }

    @Test
    fun testNonNumber() {
        assertFailsWith<TypeError>("Strings aren't integers") { isOdd("bruh moment") }
    }

    @Test
    fun strings() {
        assertTrue(isOdd("1"))
        assertTrue(isOdd("1.0"))
        assertTrue(isOdd("3.0"))

        assertFailsWith<Error> { isOdd("1.1") }
        assertFailsWith<Error> { isOdd("3.3") }
    }

    @Test
    fun eventStrings() {
        assertFalse(isOdd("2"))
        assertFalse(isOdd("2.0"))
        assertFalse(isOdd("4.0"))
    }
}
