import com.arthlimchiu.utils.currency.DEFAULT_DECIMAL_PLACES
import com.arthlimchiu.utils.currency.ext.convertToCents
import com.arthlimchiu.utils.currency.ext.parseCentsToBigDecimal
import org.junit.Assert.assertEquals
import org.junit.Test
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.exp

class CentsTest {

    @Test
    fun convertToCents_shouldReturnStringInCents() {
        val expected = 1_580L
        val actual = BigDecimal(15.80).convertToCents()

        assertEquals(expected, actual)
    }

    @Test
    fun parseCentsToBigDecimal_shouldReturnBigDecimalWithTwoDecimalPlaces() {
        val expected = BigDecimal(15.80).setScale(DEFAULT_DECIMAL_PLACES, RoundingMode.HALF_EVEN)
        val actual = 1_580L.parseCentsToBigDecimal()

        assertEquals(expected, actual)
    }
}