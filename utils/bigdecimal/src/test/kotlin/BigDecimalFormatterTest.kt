import com.arthlimchiu.utils.bigdecimal.ext.parseBigDecimalToString
import com.arthlimchiu.utils.bigdecimal.ext.parseStringToBigDecimalString
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test
import java.math.BigDecimal

class BigDecimalFormatterTest {

    @Test
    fun parseBigDecimalToString_returnsAStringWithTwoDecimalPlaces() {
        val actual = BigDecimal(12.5678).parseBigDecimalToString()
        assertEquals("12.57", actual)
    }

    @Test
    fun whenStringIsBlank_parseStringToBigDecimalString_returnsBlankString() {
        val actual = "".parseStringToBigDecimalString()
        assertEquals("", actual)
    }

    @Test
    fun whenStringIsOnlyAPeriod_parseStringToBigDecimalString_returnsPeriod() {
        val actual = ".".parseStringToBigDecimalString()
        assertEquals(".", actual)
    }

    @Test
    fun parseStringToBigDecimalString_returnsExactBigDecimalInString() {
        val actual = "12.5678".parseStringToBigDecimalString()
        assertEquals("12.5678", actual)
    }

    @Test
    fun parseStringToBigDecimalString_returnsExactBigDecimalInString_withoutRoundingOff() {
        val actual = "12.5678".parseStringToBigDecimalString()
        assertNotEquals("12.57", actual)
    }
}