import me.schlaubi.is_odd.isOdd
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

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

    @Test
    fun testFloatingPoint() {
        assertFalse(isOdd(2F), "Floats aren't integers")
        assertFalse(isOdd(Float.MAX_VALUE), "Floats aren't integers")
    }

    @Test
    fun testNonNumber() {
        assertFalse(isOdd("bruh moment"), "Strings aren't integers")
    }
}
