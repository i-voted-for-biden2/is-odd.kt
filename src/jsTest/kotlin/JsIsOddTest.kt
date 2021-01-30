import me.schlaubi.is_odd.isOdd
import kotlin.test.Test
import kotlin.test.assertFailsWith

class JsIsOddTest {
    @Suppress("UnsafeCastFromDynamic")
    @Test
    fun testNonNumber() {
        // This should work but K/Js is bugged
//        assertFailsWith<TypeError>("Strings aren't integers") { isOdd(object {}) }
//        assertFailsWith<TypeError>("Strings aren't integers") { isOdd("".asDynamic()) }
    }

    @Suppress("INTEGER_OVERFLOW") // It doesn't cuz JS
    @Test
    fun testExceed() {
        assertFailsWith<Error> { isOdd(Long.MAX_VALUE + 1) }
    }
}
