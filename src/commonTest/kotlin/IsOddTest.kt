import me.schlaubi.is_odd.TypeError
import me.schlaubi.is_odd.isOdd
import kotlin.test.Test
import kotlin.test.assertFailsWith
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
    fun testNonNumber() {
        assertFailsWith<TypeError>("Strings aren't integers") { isOdd("bruh moment") }
    }
}
