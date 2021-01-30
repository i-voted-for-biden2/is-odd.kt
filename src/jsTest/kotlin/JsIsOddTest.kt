import me.schlaubi.is_odd.isOdd
import kotlin.test.Test
import kotlin.test.assertFalse

class JsIsOddTest {
    @Suppress("UnsafeCastFromDynamic")
    @Test
    fun testNonNumber() {
        assertFalse(isOdd(object {}), "Strings aren't integers")
        assertFalse(isOdd("".asDynamic()), "Strings aren't integers")
    }
}
